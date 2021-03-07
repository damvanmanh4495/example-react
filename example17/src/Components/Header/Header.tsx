import React, { useContext } from 'react'
import { Link } from 'react-router-dom';
import { authContext } from '../../utils/AuthContext';
import "./Header.css";

export default function Header() {
    const { setAuthData, auth }: any = useContext(authContext);

    const handleLogout = () => {
        setAuthData(null, null)
    }

    var user = auth.data;
    let box;
    if (user === null) {
        box = (<div className="header d-flex justify-content-end">
            <div className="account-register">
                <a href="a">Đăng ký</a>
            </div>
            <div className="account-login">
                <Link to="/login">Đăng nhập</Link>
            </div>
        </div>);
    } else {
        box = (<div className="header d-flex justify-content-end">
            <div className="account-register">
                <span >Xin chào, {user}</span>
            </div>
            <div className="account-login">
                <button
                    onClick={handleLogout}>Đăng xuất</button>
            </div>
        </div>);
    }
    return (
        <div>
            {box}
        </div>
    )
}
