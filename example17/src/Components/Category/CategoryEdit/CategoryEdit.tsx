import React, { useContext, useEffect, useState } from 'react';
import { authContext } from '../../../utils/AuthContext';
import axios from 'axios';
import { axios_config } from '../../../utils/Common';

interface Props {
    match: any,
    history: any
}

function CategoryEdit(props: Props) {

    const [category, setCategory] = useState({
        name: '',
        code: '',
        descriptions: '',
    })
    const [dataStatus, setDataStatus] = useState(0);
    const [success, setSuccess] = useState(false);
    const [alert1, setAlert1] = useState('');

    const { auth }: any = useContext(authContext);

    function handleChange(e: any) {
        var target = e.target;
        var name = target.name;
        var value = target.value;
        setCategory({
            ...category,
            [name]: value,
        })
    }
    useEffect(() => {
        getAPICategory();
    }, []);

    async function getAPICategory() {
        var id = props.match.params.id;
        if (id !== undefined) {
            await axios
                .get("/admin/categories/" + id)
                .then(response => {
                    setCategory(response.data);
                })
                .catch(err => console.log(err));
        } else {
            return null;
        }
    }
    const handleSubmitUpdate = async (event: any) => {
        const data = category;
        const id = props.match.params.id;
        event.preventDefault();
        await axios
            .put('/admin/categories/' + id, data, axios_config(auth.token))
            .then(res => {
                if (res.status === 200) {
                    setDataStatus(res.status);
                    setAlert1('Sửa thành công !');
                    alert('Sửa thành công !');
                    props.history.goBack();
                }
            })
            .catch(error => {
                setDataStatus(error.response.status);
                setAlert1("Sửa thất bại ! " + error.response.statusText + "");
            });
        setSuccess(true);
    }
    const handleSubmitCreate = async (event: any) => {
        const data = category;
        event.preventDefault();
        await axios
            .post('/admin/categories', data, axios_config(auth.token))
            .then(res => {
                if (res.status === 201) {
                    setDataStatus(res.status);
                    setAlert1('Thêm thành công !');
                    alert('Thêm thành công !');
                    props.history.goBack();
                }
            })
            .catch(error => {
                setDataStatus(error.response.status);
                setAlert1("Thêm thất bại ! " + error.response.statusText + "");
            });
        setSuccess(true);
    }

    const handleBack = () => {
        props.history.goBack();
    }

    let alterCo;
    if (success) {
        alterCo = <div className={dataStatus === 200 ? "alert alert-success" : "alert alert-danger"} role="alert">
            {alert1}
        </div>
    };
    return (
        <div className="card card-primary" style={{ width: '700px', margin: '20px auto', }}>
            <div className="card-header d-flex justify-content-between">
                <h3 className="card-title">{props.match.params.id !== undefined ? 'Sửa loại danh mục' : 'Thêm loại danh mục'}</h3>
            </div>
            <div>{alterCo}</div>
            <form method='post' onSubmit={props.match.params.id !== undefined ? handleSubmitUpdate : handleSubmitCreate}>
                <div className="card-body">
                    <div className="form-group">
                        <label htmlFor="exampleInputCode">Mã danh mục</label>
                        <input type="text" className="form-control" value={category.code} name="code" onChange={handleChange} id="exampleInputCode" placeholder="Mã danh mục" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="exampleInputName">Tên danh mục</label>
                        <input type="text" className="form-control" name="name" value={category.name} onChange={handleChange} id="exampleInputName" placeholder="Tên danh mục" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="exampleInputDescription">Mô tả</label>
                        <input type="text" className="form-control" value={category.descriptions} name="descriptions" onChange={handleChange} id="exampleInputDescription" placeholder="Mô tả" />
                    </div>
                </div>
                <div className="card-footer">
                    <button type="submit" className="btn btn-primary">{props.match.params.id !== undefined ? 'Cập nhật' : 'Thêm mới'}</button>
                    <button type="button" onClick={handleBack} className="btn btn-danger ml-2">Quay lại</button>
                </div>
            </form>
        </div>
    );
}


export default CategoryEdit;