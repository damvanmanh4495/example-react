import React, { createContext, Component } from 'react';

export const authContext = createContext({});
class AuthProvider extends Component {
    constructor(props) {
        super(props);
        this.state = {
            auth: {
                loading: true,
                data: '',
                token: '',
            },
        }
    }

    componentDidMount() {
        this.setState({
            auth: {
                loading: false,
                token: JSON.parse(window.localStorage.getItem('authData')),
                data: JSON.parse(window.localStorage.getItem('data')),
            }
        });
    }

    componentDidUpdate(prevProps, prevState) {
        if (prevState.auth.token !== this.state.auth.token) {
            window.localStorage.setItem('authData', JSON.stringify(this.state.auth.token));
            window.localStorage.setItem('data', JSON.stringify(this.state.auth.data));
        }
    }

    render() {
        const setAuthData = (data, token) => {
            this.setState({
                auth: {
                    data: data,
                    token: token,
                }
            });
        };
        let auth = this.state.auth;
        return (
            <authContext.Provider value={{ auth, setAuthData }}>
                {this.props.children}
            </authContext.Provider>
        );
    }

}
export default AuthProvider;