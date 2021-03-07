import React from 'react';
import PropTypes from 'prop-types';
import { ICategory } from '../../../utils/Type';
import { Link } from 'react-router-dom';

CategoryDetail.propTypes = {
    categoryDetail: PropTypes.object.isRequired,
    onClickDelete: PropTypes.func
};

CategoryDetail.defaultProps = {
    onClickDelete: null,
}

interface Props {
    onClickDelete: any,
    categoryDetail: ICategory,
}

function CategoryDetail(props: Props) {
    const { onClickDelete, categoryDetail } = props;
    function handleDelete() {
        if (onClickDelete) {
            onClickDelete()
        }
    }

    let showDetail: any;
    if (categoryDetail.id !== undefined) {
        showDetail = <tr >
            <td>
                <Link to={'/category-list/edit/' + categoryDetail.id} className="btn btn-warning">Xem chi tiết danh mục</Link>
            </td>
            <td style={{ border: 'none' }}>
                <button onClick={handleDelete} className="btn btn-danger">Xóa danh mục</button>
            </td>
        </tr>
    }
    return (
        <div>
            <table className="table" id="show-detail">
                <tbody>
                    <tr>
                        <th>ID:</th>
                        <td >{categoryDetail.id}</td>
                    </tr>
                    <tr>
                        <th>Mã danh mục:</th>
                        <td >{categoryDetail.code}</td>
                    </tr>
                    <tr>
                        <th>Tên danh mục:</th>
                        <td >{categoryDetail.name}</td>
                    </tr>
                    <tr>
                        <th>Mô tả:</th>
                        <td >{categoryDetail.descriptions}</td>
                    </tr>
                    <tr>
                        <th>Ngày tạo:</th>
                        <td >{categoryDetail.created}</td>
                    </tr>
                    <tr>
                        <th>Ngày sửa:</th>
                        <td >{categoryDetail.modified}</td>
                    </tr>
                </tbody>
            </table>
            {showDetail}
        </div>
    );
}

export default CategoryDetail;