import React, { Component } from "react";
import  "./CategoryDetail.css";

class CategoryDetail extends Component {
  render() {
    return (
      <div className="category-details">
        <table class="table table-bordered">
          <tbody>
            <tr>
              <th scope="row">Name</th>
              <td>{this.props.name}</td>
            </tr>
            <tr>
              <th scope="row">Title</th>
              <td>{this.props.title}</td>
            </tr>
            <tr>
              <th scope="row">Descriptions</th>
              <td>{this.props.descriptions}</td>
            </tr>
            <tr>
              <th scope="row">Status</th>
              <td>{this.props.status}</td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}

export default CategoryDetail;
