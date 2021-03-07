import axios from 'axios';
import React, { useContext, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { authContext } from '../../../utils/AuthContext';
import { axios_config } from '../../../utils/Common';
import { ICategory } from '../../../utils/Type';
import Pagination from '../../Pagination/Pagination';
import Selection from '../../Selection/Selection';
import CategoryDetail from '../CategoryDetail/CategoryDetail';
import CategoryItem from '../Categoryitem/CategoryItem';

import './cate.css'


function CategoryList() {
    const [categories, setCategories] = useState<ICategory[]>([]);
    const [categoryDetail, setCategoryDetail] = useState<ICategory>({ id: 1 });
    const [detailStatus, setDetailStatus] = useState(false);

    const { auth }: any = useContext(authContext);

    const [pagination, setPagination] = useState({
        page: 1,
        size: 3,
        totalItem: 0,
    });

    const [success, setSuccess] = useState(false);

    function handleShowCate(category: ICategory) {
        setCategoryDetail(category);
        setDetailStatus(true);
    }

    function handlePage(e: any) {
        setPagination({
            ...pagination,
            page: Number(e.target.innerHTML),
        })
    }

    function handleSelect() {
        let select = (document.getElementById('sl-limit') as HTMLInputElement);
        let e = select.value;
        setPagination({
            ...pagination,
            size: Number(e),
            page: 1,
        });
    }

    function handlePrevious() {
        if (pagination.page >= 1) {
            setPagination({
                ...pagination,
                page: pagination.page - 1
            })
        }
    }

    function handleNext() {
        const totalRow = Math.ceil(pagination.totalItem/pagination.size)
        if (pagination.page < totalRow) {
            setPagination({
                ...pagination,
                page: pagination.page + 1
            })
        }
    }

    const getAPICategory = async () => {
        await axios
            .get("/admin/categories?page=" + pagination.page + "&size=" + pagination.size + "")
            .then(response => {
                setCategories(response.data.categories);
                setPagination({
                    ...pagination,
                    totalItem: response.data.total_page,
                });
            })
            .catch(err => console.log(err.response.statusText));
    }

    async function handleDelete(id: number) {
        await axios
            .delete('/admin/categories/' + id, axios_config(auth.token))
            .then(res => {
                if (res.status === 200) {
                    alert('Delete success !');
                    setSuccess(true);
                    setDetailStatus(false);
                }
            })
            .catch(error => {
                alert('Delete fail !');
            });
    }

    useEffect(() => {
        getAPICategory();
    }, []);

    useEffect(() => {
        getAPICategory();
    }, [pagination.page, pagination.size, success]);

    let categoryItem = categories.map((category) => {
        return <CategoryItem
            key={category.id}
            name={category.name}
            onClickShow={() => handleShowCate(category)}
        />
    });

    let boxDetail;
    if (detailStatus) {
        var detail = categoryDetail;
        boxDetail = (<CategoryDetail
            categoryDetail={categoryDetail}
            onClickDelete={() => handleDelete(detail.id)}
        />);
    } else {
        boxDetail = <div></div>
    }

    return (
        <div>
            <div className="container">
                <div className="row">
                    <div className="col-lg-3">
                        <div>
                            <div>
                                <Link to='/category-list/edit' className="btn btn-primary">Thêm mới</Link>
                            </div>
                            <div>
                                <div>
                                    <Selection
                                        onChangeSelect={handleSelect}
                                    />
                                    <div>
                                        <ul className="list-category">
                                            {categoryItem}
                                        </ul>
                                    </div>
                                    <Pagination
                                        pagination={pagination}
                                        onClickPage={handlePage}
                                        onClickPrevious={handlePrevious}
                                        onClickNext={handleNext}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-9">
                        {boxDetail}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CategoryList;