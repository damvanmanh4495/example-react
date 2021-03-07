
import React, { useContext } from 'react'
import { Redirect, Route } from 'react-router-dom';
import { authContext } from './AuthContext'

export default function PublicRoute({component: Component, ...rest}: any) {

    const {auth}: any = useContext(authContext);

    return (
        <Route 
            {...rest}
            render={(routeProps:any) => (
                !auth.token ? <Component {...routeProps} /> : <Redirect to={{pathname:'category-list'}} />
            )}
        />
    )
}
