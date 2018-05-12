import React from 'react';

import Todo from './Todo';

const TodoList = (prop) => {
  const todos = [];
  for (const todo in prop.todos) {
    todos.push(<Todo todo={todo}/>);
  }

  return (
      <ul>{todos}</ul>
  );
};

export default TodoList;