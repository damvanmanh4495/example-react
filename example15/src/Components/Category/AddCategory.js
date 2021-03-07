import React, { Component } from "react";
import "./Category.css";
import axios from "axios";
import CategoriesService from "../../services/CategoriesService";
import { Link } from "react-router-dom";


class AddCategory extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.id,
      code: "",
      name: "",
      descriptions: "",
    };
  }

  componentDidMount() {
    console.log(this.state.id);
  }

  handleChangeCode = (e) => {
    this.setState({ code: e.target.value });
  };

  handleChangeName = (e) => {
    this.setState({ name: e.target.value });
  };

  handleChangeDescriptions = (e) => {
    this.setState({ descriptions: e.target.value });
  };

  handleSubmit = async (e) => {
    e.preventDefault();
    let category = {
      id: this.props.match.params.id,
      code: this.state.code,
      name: this.state.name,
      descriptions: this.state.descriptions,
    };

    await CategoriesService.create(category)
      .then((res) => {
        if (res.status === 201) {
          alert("Thêm mới thành công");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  handleClickCancel = (e) => {
    this.props.history.goBack("/categories");
  };

  render() {
    return (
      <div className="container">
        <div className="form-add">
        <h2>Add Category</h2>
          <form onSubmit={this.handleSubmit}>
            <table>
              <tr>
                <td>Code</td>
                <td>
                  <input
                    required
                    value={this.state.code}
                    onChange={this.handleChangeCode}
                  />
                </td>
              </tr>
              <tr>
                <td>Name</td>
                <td>
                  <input
                    required
                    value={this.state.name}
                    onChange={this.handleChangeName}
                  />
                </td>
              </tr>
              <tr>
                <td>Descriptions</td>
                <td>
                  <textarea
                    value={this.state.descriptions}
                    onChange={this.handleChangeDescriptions}
                  />
                </td>
              </tr>
              <tr>
                <td></td>
                <td>
                  <input
                    type="submit"
                    value="Add"
                    className="btn btn-primary"
                  ></input>
                </td>
              </tr>
            </table>
          </form>
          <button onClick={this.handleClickCancel} className="btn btn-danger btn-cancel">
          <i class="fa fa-arrow-left" aria-hidden="true"></i>
          </button>
        </div>
      </div>
    );
  }
}

export default AddCategory;
