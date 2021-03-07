import React, { Component } from "react";
import Login from "./Components/Login";
import CategoryList from "./Components/Category/CategoryList";
import AddCategory from "./Components/Category/AddCategory"
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Dashboard from "./Components/Dashboard/Dashboard";
import UpdateCategory from "./Components/Category/UpdateCategory";
import PrivateRoute from "./auth/PrivateRoute";
import PublicRoute from "./auth/PublicRoute";

function App() {
  return (
    <BrowserRouter>
      <div>
        <div className="content">
          <Switch>
            <Route exact path="/" component={Dashboard} />
            <PrivateRoute exact path="/dashboard" component={Dashboard} />
            <PublicRoute path="/login" component={Login} />
            <PrivateRoute exact path="/categories" component={CategoryList} />
            <Route
              exact
              path="/categories/add"
              component={AddCategory}
            />
            <Route
              exact
              path="/categories/update/:id"
              component={UpdateCategory}
            />
          </Switch>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
