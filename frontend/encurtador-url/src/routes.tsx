import React from 'react';
import { Route, Redirect, Switch } from 'react-router-dom';

import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register'

import { isAuthenticated } from './services/auth';

const PrivateRoute = ({...rest}) => {
    return isAuthenticated() ? <Route {...rest}/> : <Redirect to="/login"/>
}

function Routes() {
    return (
        <Switch>
            <Route path="/login" component={Login}></Route>
            <Route path="/register" component={Register}></Route>
            <PrivateRoute path="/" exact component={Home}></PrivateRoute>
            <Redirect from="*" to="/" />
        </Switch>
    );
}

export default Routes;


/*       <Route path="/" component={Home}/>*/

/*<Route  path="*" component={() => <h1>Page Not Found!</h1>}/>*/