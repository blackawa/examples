import React from 'react';
import {connect} from 'react-redux';

import Todo from './Todo';

const TodoList = (props) => {
  const todos = [];
  for (const i in props.todos) {
    todos.push(<Todo key={i} todo={props.todos[i]}/>);
  }

  return (
      <ul>{todos}</ul>
  );
};

export default connect(state => state)(TodoList);