import React from 'react';
import {hot} from 'react-hot-loader';
import {BrowserRouter, Route, Link} from 'react-router-dom';

const Home = () => <div><h2>This is home.</h2></div>;
const About = () => <div><h2>This is about.</h2></div>;
const Topics = () => <div>
  This is topics.
  <ul>
    <li><Link to='/topics/1'>Topic 1</Link></li>
    <li><Link to='/topics/2'>Topic 2</Link></li>
  </ul>
  <Route path='/topics/:topicId' component={Topic}/>
</div>;
const Topic = (props) => <div>
  This is a topic {props.match.params.topicId}
</div>;

const App = () => <BrowserRouter>
  <div>
    <ul>
      <li><Link to='/'>Home</Link></li>
      <li><Link to='/about'>About</Link></li>
      <li><Link to='/topics'>Topics</Link></li>
    </ul>
    Hello from react. env is {process.env.NODE_ENV}
    <Route exact path='/' component={Home}/>
    <Route path='/about' component={About}/>
    <Route path='/topics' component={Topics}/>
  </div>
</BrowserRouter>;

const WrappedApp = process.env.NODE_ENV === 'development' ? hot(module)(App) : App;

export default WrappedApp;
