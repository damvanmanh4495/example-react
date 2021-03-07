import React from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

CategoryDetail.propTypes = {
  category: PropTypes.object.isRequired,
  onClickDelete: PropTypes.func,
};

CategoryDetail.defaultProps = {
  onClickDelete: null,
};

function CategoryDetail(props) {
  const { category } = props;
  console.log(category);
  const { onClickDelete, onClickUpdate } = props;
  function handleDelete() {
    if (onClickDelete) {
      onClickDelete();
    }
  }

  function handleUpdate() {
    if (onClickUpdate) {
      onClickUpdate();
    }
  }

  return (
    <div className="category-details">
      <table className="table table-bordered">
        <tbody>
          <tr>
            <td>Id</td>
            <td>{category.id}</td>
          </tr>
          <tr>
            <td>Code</td>
            <td>{category.code}</td>
          </tr>
          <tr>
            <td>Name</td>
            <td>{category.name}</td>
          </tr>
          <tr>
            <td>Descriptions</td>
            <td>{category.descriptions}</td>
          </tr>
          <tr>
            <td>Created</td>
            <td>{category.created}</td>
          </tr>
          <tr>
            <td>Modified</td>
            <td>{category.modified}</td>
          </tr>
        </tbody>
      </table>
      <button onClick={handleDelete} className="btn btn-danger">
        Delete
      </button>
      <Link to={"/categories/edit" + props.category.id}>
        <button onClick={handleUpdate} className="btn btn-success">
          Edit
        </button>
      </Link>
    </div>
  );
}

export default CategoryDetail;
