import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import CategoryEdit from './Components/Category/CategoryEdit/CategoryEdit';
import CategoryList from './Components/Category/CategoryList/CategoryList';
import Header from './Components/Header/Header';
import Home from './Components/Home/Home';
import Login from './Components/Login/Login';
import PrivateRoute from './utils/PrivateRoute';
import PublicRoute from './utils/PublicRoute';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Switch>
          <Route exact path="/" component={Home} />
          <PublicRoute path="/login" component={Login} />
          <PrivateRoute exact path="/category-list" component={CategoryList} />
          <PrivateRoute path="/category-list/edit/:id" component={CategoryEdit} />
          <PrivateRoute path="/category-list/edit" component={CategoryEdit} />
        </Switch>

      </BrowserRouter>
    </div>
  );
}

export default App;
