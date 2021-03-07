import React from 'react'
import { Redirect, Route } from 'react-router';
import { useAuth } from '../context/auth';

export default function PrivateRoute({path: path, component: Component, ...rest}) {
    const {authentication} = useAuth();

    return (
        <Route
            {...rest}
            render={props => (
                authentication.token ?
                    <Component {...props} />
                    :
                    <Redirect             
                        to={{ pathname: "/login", state: { prevLocation: path } }} />
            )
            }
        />
    );
}
