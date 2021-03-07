import React from "react";
import PropTypes from "prop-types";
import "./Pagination.css";

Pagination.propTypes = {
  onClickPage: PropTypes.func,
  onClickPrevious: PropTypes.func,
  onClickNext: PropTypes.func,
};

Pagination.defaultProps = {
  onClickPage: null,
  onClickPrevious: null,
  onClickNext: null,
};

function Pagination(props) {
  const { pagination, onClickPage, onClickPrevious, onClickNext } = props;

  const totalRow = Math.ceil(pagination.totalPage / pagination.size);

  function handlePage(e) {
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
  const pageNumber = [];
  for (let i = 0; i < totalRow; i++) {
    if (pagination.page === i) {
      pageNumber[i] = (
        <li className="page-item active" key={i + 1}>
          <span className="page-link" onClick={handlePage}>
            {i + 1}
          </span>
        </li>
      );
    } else {
      pageNumber[i] = (
        <li className="page-item" key={i + 1}>
          <span className="page-link" onClick={handlePage}>
            {i + 1}
          </span>
        </li>
      );
    }
  }
  return (
    <nav aria-label="Page navigation example" className="ex1">
      <ul className="pagination">
        <li
          className={
            pagination.page === 0 ? "page-item  disabled" : "page-item"
          }
          onClick={handleChangePrevious}
        >
          <span className="page-link">Previous</span>
        </li>
        {pageNumber}
        <li
          className={
            pagination.page >= totalRow - 1
              ? "page-item  disabled"
              : "page-item"
          }
          onClick={handleChangeNext}
        >
          <span className="page-link">Next</span>
        </li>
      </ul>
    </nav>
  );
}

export default Pagination;
