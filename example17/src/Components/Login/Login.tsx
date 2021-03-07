import axios from 'axios';
import React, { useContext, useState } from 'react'
import { Link } from 'react-router-dom';
import { authContext } from '../../utils/AuthContext';
import "./Login.css";

interface Props {
    history: any;
}

export default function Login(props: Props) {
    const [account, setAccount] = useState({
        username: "",
        password: ","
    });

    const { setAuthData }: any = useContext(authContext);

    function handleChange(event: any) {
        var target = event.target;
        var name = target.name;
        var value = target.value;
        setAccount({
            ...account,
            [name]: value,
        });
    }

    async function callApiLogin() {
        const data = account;
        await axios.post('api/auth/signin', data)
            .then(res => {
                console.log(res);
                setAuthData(data.username, res.data.accessToken);
                if (res.status === 200) {
                    props.history.push('/category-list');
                }
            })
            .catch(e => {
                alert("Fail success")
            });
    }

    function handleLogin(event: any) {
        callApiLogin();
        event.preventDefault();
    }
    return (
        <div>
            <div className="container">
                <div className="section-link">
                    <span className="home"><Link to="/">Trang chủ</Link></span>
                    <span className="login"><Link to="/login">Đăng nhập</Link></span>
                </div>
                <div className="login-form">
                    <h3>Đăng nhập</h3>
                    <form action="" method='post' onSubmit={handleLogin}>
                        <table>
                            <tbody>
                                <tr>
                                    <td>Username</td>
                                    <td> <input type="text" className="form-control" required name="username" onChange={handleChange} /></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td>
                                        <input type="password" name="password" required onChange={handleChange} className="form-control" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div>
                            <button
                                type="submit"
                                className="btn btn-primary"
                            >Đăng nhập
                            </button>
                            <button
                                type="button"
                                className="btn btn-danger"
                            >
                                <Link
                                    to="/"
                                    className="back-login"
                                >Quay lại
                                </Link>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}
