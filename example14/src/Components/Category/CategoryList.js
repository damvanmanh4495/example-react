import React, { Component } from "react";
import CategoryItem from "./CategoryItem";
import CategoryDetail from "./CategoryDetail";
import Axios from "axios";
import Pagination from "./Pagination";
import "../../App.css";
import { Link } from "react-router-dom";
import axios from "axios";
import CategoriesService from "../../services/CategoriesService";

const CATEGORIES_BASE_URL = "/admin/categories";
class CategoryList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      categories: {
        total_page: 0,
        categories: [],
      },

      categoryDetails: "",
      error: null,
      isLoaded: false,
      page: 0,
      size: 3,
      showDetails: 0,
    };
  }

  callApi = () => {
    Axios.get(
      CATEGORIES_BASE_URL +
        "?page=" +
        this.state.page +
        "&size=" +
        this.state.size
    )
      .then((res) => res.data)
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            categories: result,
          });
        },
        (error) => {
          this.setState({
            isLoaded: true,
            error,
          });
        }
      );
  };
  componentDidMount() {
    this.callApi();
  }

  componentDidUpdate(prevProps, prevState) {
    if (this.state.page !== prevState.page) {
      this.callApi();
    }
  }
  onItemClick = (category) => {
    return (event) => {
      this.setState({ categoryDetails: category, showDetails: 1 });
    };
  };

  handlePrev = () => {
    if (this.state.page > 0) {
      this.setState({ page: this.state.page - 1 });
    }
  };

  handleNext = () => {
    let { size, page } = this.state;
    let total_page = this.state.categories.total_page;
    if (page < total_page / size - 1) {
      this.setState({ page: page + 1 });
    }
  };

  handlePageNumber = (e) => {
    this.setState({ page: e.target.getAttribute("value") - 1 });
  };

  handleClickDelete = (cate) => {
    CategoriesService.deleteById(cate.id)
    .then(res => {
      if(res.status === 200){
        this.setState({showDetails: 0});
        this.callApi();
        alert("Đã xoá thành công")
      }
    })
    .catch(err => {
      console.log(err)
      alert("Có lỗi xảy ra")
    })
  }

  handleClickUpdate = (cate) => {
      this.props.history.push(`/categories/update/${cate.id}`)
  }

  renderDetail = () => {
    let cate = this.state.categoryDetails;
    if(this.state.showDetails === 0){
      return null;
    } else {
      return (
        <div>
          <CategoryDetail
            id={cate.id}
            code={cate.code}
            name={cate.name}
            descriptions={cate.descriptions}
            created={cate.createdNew}
            modified={cate.createdEdit}
          />
          <button className="btn btn-danger" onClick={() => this.handleClickDelete(cate)}>Delete</button>
          <button className="btn btn-success" onClick={() => this.handleClickUpdate(cate)}>Update</button>
        </div>
      );
    }
  
  };

  render() {
    const { error, isLoaded, categories, pageNumber, itemsInPage } = this.state;
    const start = (pageNumber - 1) * itemsInPage;
    const categories1 = categories.categories;
    const categoriesOnePage = categories1;

    if (error) {
      return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
      return <div>Loading...</div>;
    } else {
      return (
        <div className="container category_list">
          <div>
            <h1>Categories</h1>
            <div className="row">
              <div className="col-lg-3">
                <button className="btn btn-success">
                  <Link to="/categories/add">Add</Link>{" "}
                </button>
                <ul>
                  {categoriesOnePage.map((category, index) => (
                    <li onClick={this.state.classActive} key={index}>
                      <CategoryItem
                        key={index}
                        item={category}
                        onClick={this.onItemClick(category)}
                      />
                    </li>
                  ))}
                </ul>
                <div>
                  <Pagination
                    totalPage={categories.total_page}
                    size={this.state.size}
                    pageNumber={this.handlePageNumber}
                    prevPage={this.handlePrev}
                    nextPage={this.handleNext}
                    currentPage={this.state.page}
                  />
                </div>
              </div>
              <div className="col-lg-9 ">{this.renderDetail()}</div>
            </div>
          </div>
        </div>
      );
    }
  }
}

export default CategoryList;
