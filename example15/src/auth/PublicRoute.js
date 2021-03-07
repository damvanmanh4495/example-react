import React, { Component } from 'react';
import { Route, Redirect } from 'react-router-dom';
import { authContext } from './AuthContext';
// handle the public routes
class PublicRoute extends Component {
    render() {
        const { component: Component, ...rest } = this.props;
        const { auth } = this.context;

        return (
            <Route
                {...rest}
                render={(props) => auth.token !== "aaaa" ? <Component {...props} /> : <Redirect to={{ pathname: '/categories' }} />}
            />
        )
    }
}
PublicRoute.contextType = authContext;
export default PublicRoute;