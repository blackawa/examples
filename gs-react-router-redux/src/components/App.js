import React from 'react';
import {Route} from 'react-router-dom';
import Inheritee from "./Inheritee";
import Children from "./Children";

export default ({}) => {
  return <div>
    <Route path='/' exact component={() => <div>Root page</div>}/>
    <Route path='/inheritee' component={Inheritee}/>
    <Route path='/children' component={Children}/>
  </div>
};