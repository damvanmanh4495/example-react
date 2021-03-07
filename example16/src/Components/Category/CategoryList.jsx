import React, { useEffect, useState } from "react";
import axios from "axios";
import CategoryItem from "./CategoryItem";
import CategoryDetail from "./CategoryDetail";
import Pagination from "../Pagination/Pagination";
import "./Category.css";
import { getListCategories } from "../../service/Categories";


CategoryList.propTypes = {};

function CategoryList(props) {
  const [categories, setCategories] = useState([]);
  const [categoryDetail, setCategoryDetail] = useState({});
  const [detailStatus, setDetailStatus] = useState(false);
  const [update, setUpdate] = useState(false);

  const [pagination, setPagination] = useState({
    page: 0,
    size: 2,
    totalPage: 0,
  });

  function handleShowCate(category) {
    setCategoryDetail(category);
    setDetailStatus(true);
  }

  function handlePage(e) {
    setPagination({
      ...pagination,
      page: (Number(e.target.innerHTML) - 1),
    });
  }

  function handlePrevious() {
    if (pagination.page >= 1) {
      setPagination({
        ...pagination,
        page: pagination.page - 1,
      });
    }
  }

  function handleNext() {
    if (pagination.page <= (pagination.totalPage/pagination.size - 1)) {
      setPagination({
        ...pagination,
        page: pagination.page + 1,
      });
    }
  }
  const fetchCategories = async (pagination) => {
    let result = await getListCategories(pagination.page, pagination.sizePage);
    setCategories(result.categories);
    setPagination({ ...pagination, total: result.total });
  };

  useEffect(() => {
    fetchCategories(pagination);
  }, [pagination.size, pagination.page, update]);

  async function handleDelete(id) {
    await axios
        .delete('/admin/categories/' + id)
        .then(res => {
            if (res.status === 200) {
                alert('Xóa thành công !');
                setUpdate(true);
                setDetailStatus(false);
            }
        })
        .catch(error => {
            alert('Xóa thất bại !');
        });
}


  let categoryItem = categories.map((category) => {
    return (
      <CategoryItem
        key={category.id}
        name={category.name}
        onClickShow={() => handleShowCate(category)}
      />
    );
  });

  let boxDetail;
  if (detailStatus === true) {
    boxDetail = <CategoryDetail 
    category={categoryDetail} 
    onClickDelete = {() => handleDelete(categoryDetail.id)}
    />;
  }

  return (
    <div className="container">
        <h3>List categories</h3>
      <div className="row">
        <div className="col-lg-3">
          <ul>{categoryItem}</ul>
          <div>
            <Pagination 
                pagination={pagination}
                onClickPage = {handlePage}
                onClickPrevious = {handlePrevious}
                onClickNext = {handleNext}
            />
          </div>
        </div>
        <div className="col-lg-9">{boxDetail}</div>
      </div>
    </div>
  );
}

export default CategoryList;
