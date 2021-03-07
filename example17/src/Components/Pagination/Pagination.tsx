import React from 'react';
import PropTypes from 'prop-types';

Pagination.propTypes = {
    onClickPage: PropTypes.func,
    onClickPrevious: PropTypes.func,
    onClickNext: PropTypes.func,
};

Pagination.defaultProps = {
    onClickPage: null,
    onClickPrevious: null,
    onClickNext: null,
}
interface IPagination {
    page: number,
    size: number,
    totalItem: number,
}
interface Props {
    pagination: IPagination,
    onClickPage: any,
    onClickPrevious: any,
    onClickNext: any
}

function Pagination(props: Props) {
    const { pagination, onClickPage, onClickPrevious, onClickNext } = props;

    function handlePage(e: any) {
        if (onClickPage) {
            onClickPage(e);
        }
    }

    function handleChangePrevious() {
        if (onClickPrevious) {
            onClickPrevious();
        }
    }

    function handleChangeNext() {
        if (onClickNext) {
            onClickNext();
        }
    }
    var pageNumber = [];
    const totalRow = Math.ceil(pagination.totalItem/pagination.size);
    for (let i = 1; i <= totalRow; i++) {
        if (pagination.page === i) {
            pageNumber[i] = (
                <li className="page-item active" key={i} >
                    <span className="page-link" onClick={handlePage}>
                        {i}
                    </span>
                </li >
            );
        } else {
            pageNumber[i] = (
                <li className="page-item" key={i} >
                    <span className="page-link" onClick={handlePage}>
                        {i}
                    </span>
                </li>
            );
        }
    }
    return (
        <nav aria-label="Page navigation example" className="ex1" >
            <ul className="pagination">
                <li
                    className={pagination.page === 1 ? "page-item  disabled" : "page-item"}
                    onClick={handleChangePrevious}>
                    <span
                        className="page-link">Previous
                    </span>
                </li>
                {pageNumber}
                <li
                    className={pagination.page === totalRow ? "page-item  disabled" : "page-item"}
                    onClick={handleChangeNext}>
                    <span className="page-link">Next</span>
                </li>
            </ul>
        </nav >
    );
}

export default Pagination;