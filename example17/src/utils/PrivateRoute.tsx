import React, { useContext } from 'react';
import { Redirect, Route } from 'react-router-dom';
import { authContext } from './AuthContext';

export default function PrivateRoute({component: Component, ...rest}:any) {

    const {auth}: any = useContext(authContext);
    return (
        <Route 
            {...rest}
            render = {(routeProps:any) => (
                auth.token ? <Component {...routeProps} /> : <Redirect to = "/login" />
            )}
        />
    )
}
