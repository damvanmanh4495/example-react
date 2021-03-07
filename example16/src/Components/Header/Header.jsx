import React from 'react';
import { Link } from 'react-router-dom';


function Header(props) {
    const {account} = props;
    return (
        <div>
            <h3>Wellcom</h3>
            <Link to="/login" >Login</Link>
            <p>Xin chào </p>
        </div>
    );
}

export default Header;