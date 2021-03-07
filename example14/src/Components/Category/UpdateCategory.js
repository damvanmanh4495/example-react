import React, { Component } from 'react';
import CategoriesService from '../../services/CategoriesService';

class UpdateCategory extends Component {
    constructor(props){
        super(props);

        this.state = {
            id: this.props.match.params.id,
            code:"",
            name:"",
            descriptions:""
        }
    }

    componentDidMount() {
        CategoriesService.getById(this.state.id).then( res => {
           let category = res.data;
            this.setState({
                code: category.code,
                name: category.name,
                descriptions:category.descriptions
            })
        })
    }

    handleChangeCode = (e) => {
        this.setState({code: e.target.value});
    }

    handleChangeName = (e) => {
        this.setState({name: e.target.value});
    }

    handleChangeDescriptions = (e) => {
        this.setState({descriptions: e.target.value});
    }

    handleSubmitUpdate = (e) => {
        e.preventDefault();
        let category = {code: this.state.code, name: this.state.name, descriptions: this.state.descriptions};
        console.log('category => ' + JSON.stringify(category));
        console.log('id => ' + JSON.stringify(this.state.id));
        CategoriesService.update(this.state.id, category).then( res => {
            if(res.status == 200){
                alert("Update success");
                this.props.history.push('/categories');
            }
        })
        .catch(err => {
            console.log(err);
            alert("Error update")
        })
        ;
    }

    handleClickCancel = (e) => {
        this.props.history.goBack("/categories");
    }
    render() {
        return (
            <div>
              <div className="container">
                <form onSubmit={this.handleSubmitUpdate}>
                  <table>
                    <tr>
                      <td>Code</td>
                      <td>
                        <input
                          value={this.state.code}
                          onChange={this.handleChangeCode}
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>Name</td>
                      <td>
                        <input
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
                <button 
                        onClick={this.handleClickCancel}
                        className="btn btn-danger">Cancel</button>
              </div>
            </div>
          );
    }
}


export default UpdateCategory;