import React from "react";
import { Route, Switch } from "react-router";
import { BrowserRouter } from "react-router-dom";
import CategoriesUpdate from "./Components/Category/CategoriesUpdate";
import CategoryList from "./Components/Category/CategoryList";
import Dashboard from "./Components/Dashboard/Dashboard";
import Footer from "./Components/Footer/Footer";
import Header from "./Components/Header/Header";
import PrivateRoute from "./route/PrivateRoute";
import PublicRoute from "./route/PublicRoute";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Switch>
        <PublicRoute path="/" component={Dashboard} />
        <PrivateRoute path="/categories" component={CategoryList} />
        <PrivateRoute path="/categories/edit" component={CategoriesUpdate} />
        <PrivateRoute
          path="/categories/edit/:id"
          component={CategoriesUpdate}
        />
      </Switch>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
