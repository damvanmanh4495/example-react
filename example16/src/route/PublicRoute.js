import React from 'react'
import { Redirect, Route } from 'react-router-dom';
import { useAuth } from '../context/auth'

export default function PublicRoute({path: path, component: Component, ...rest}) {
    const { authentication } = useAuth();
    let prevLocation = rest.location.state ? rest.location.state.prevLocation : "/";

    return (
        <Route>
            {...rest}
            render={props => (
                authentication.token ?
                    <Redirect 
                        to = {{ pathname: prevLocation}}
                    /> : 
                    <Component {...props} />
            )}

        </Route>
    )
}
