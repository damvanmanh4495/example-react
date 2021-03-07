import React, {Component} from "react";
import CategoryItem from "./CategoryItem";
import CategoryDetail from "./CategoryDetail";
import '../../App.css';

class CategoryList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            categories: [
                {
                    name: "Điện thoại",
                    title: "Tiêu đề",
                    descriptions: "Mô tả điện thoại",
                    status: "true",
                },
                {
                    name: "Máy tính",
                    title: "Tiêu đề máy tính",
                    descriptions: "Mô tả máy tính",
                    status: "true",
                },
                {
                    name: "Tablet",
                    title: "Tiêu đề Tablet",
                    descriptions: "Mô tả Tablet",
                    status: "true",
                },
                {
                    name: "Headphone",
                    title: "Tiêu đề Headphone",
                    descriptions: "Mô tả Headphone",
                    status: "true",
                },
            ],
            categoryDetails: '',
        };
    }

    onItemClick = (category) => {
        return (event) => {
            this.setState({categoryDetails: category});
        }
    }

    renderDetail = () => {
        let cate = this.state.categoryDetails;
        return (
            <div>
                <CategoryDetail
                    name={cate.name}
                    title={cate.title}
                    descriptions={cate.descriptions}
                    status={cate.status}
                />
            </div>
        );
    };

    render() {
        let category = this.state.categories.map((category, index, categories) => {
            return category;
        });

        return (
            <div className="container category_list">
                <div>
                    <h1>Categories</h1>
                    <div className="row">
                        <div className="col-lg-3">
                            <ul>
                                {category.map((category, index) => (
                                    <li onClick={this.state.classActive}>
                                        <CategoryItem key={index} item={category}
                                                      onClick={this.onItemClick(category)}/>
                                    </li>
                                ))}
                            </ul>
                        </div>
                        <div className="col-lg-6">
                            {this.renderDetail()}
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}

export default CategoryList;
