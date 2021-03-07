import React, { Component } from 'react';
import { Route, Redirect } from 'react-router-dom';
import { authContext } from './AuthContext';

class PrivateRoute extends Component {
    render() {
        const { component: Component, ...rest } = this.props;
        const { auth } = this.context;
        const { loading } = auth;
        if (loading) {
            return (
                <Route
                    {...rest}
                    render={() => {
                        return <p>Loading...</p>;
                    }}
                />
            );
        }
        return (
            <Route
                {...rest}
                render={props => {
                    return auth.token === "aaaa" ? (
                        <Component {...props} />
                    ) : (
                            <Redirect to={{ pathname: '/login', state: { from: props.location } }} />
                        );
                }}
            />
        );
    }
};
PrivateRoute.contextType = authContext;
export default PrivateRoute;