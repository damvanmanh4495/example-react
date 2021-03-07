import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Dashboard extends Component {
    render() {
        return (
            <div>
                <h1>Please login !</h1>
                <Link to={"/login"} > Login </Link>
            </div>
        );
    }
}

export default Dashboard;