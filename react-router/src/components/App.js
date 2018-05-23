import React from 'react';
import {hot} from 'react-hot-loader';
import {BrowserRouter, Route, Link} from 'react-router-dom';

const Home = () => <div><h2>This is home.</h2></div>;
const About = () => <div><h2>This is about.</h2></div>;

const App = () => <BrowserRouter>
  <div>
    <ul>
      <li><Link to='/'>Home</Link></li>
      <li><Link to='/about'>About</Link></li>
    </ul>
    Hello from react. env is {process.env.NODE_ENV}
    <Route exact path='/' component={Home}/>
    <Route path='/about' component={About}/>
  </div>
</BrowserRouter>;

const WrappedApp = process.env.NODE_ENV === 'development' ? hot(module)(App) : App;

export default WrappedApp;
