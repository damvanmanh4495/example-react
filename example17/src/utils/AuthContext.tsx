import React, { createContext, useEffect, useState } from 'react';
import axios from 'axios';
import { axios_config } from './Common'

interface Props {
    children: React.ReactNode
}

interface IAuth {
    token: string | null,
        data: string | null
}


export const authContext = createContext({});

function AuthProvider(props: Props) {


    const [auth, setAuth] = useState<IAuth>({
        token: JSON.parse(window.localStorage.getItem('token') || '{}'),
        data: JSON.parse(window.localStorage.getItem('data') || '{}'),
    });

    const verifyToken = async () => {
        let status;
        await axios.post('/api/test/verify', {}, axios_config(auth.token))
            .then(res => {
                console.log(res)
                status = res.status;
            })
            .catch(err => {
                console.log(err.response)
                status = err.response.data.status;
            });
        return status;
    }

    useEffect(() => {
        setAuth({
            token: JSON.parse(window.localStorage.getItem('token') || '{}'),
            data: JSON.parse(window.localStorage.getItem('data') || '{}'),
        })
    }, []);

    useEffect(() => {
        async function checkToken() {
            if (await verifyToken() !== 200) {
                setAuth({
                    data: null,
                    token: null,
                });
            }
        }
        window.localStorage.setItem('token', JSON.stringify(auth.token));
        window.localStorage.setItem('data', JSON.stringify(auth.data));
        checkToken();
    }, [auth.token, auth.data]);

    const setAuthData = (data: string, token: string) => {
        setAuth({
            data: data,
            token: token,
        });
    };
    return (
        <authContext.Provider value={{ auth, setAuthData }}>
            {props.children}
        </authContext.Provider>
    );
}

export default AuthProvider;

