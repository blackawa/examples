import React from 'react';
import TodoForm from './TodoForm';
import TodoList from './TodoList';

const App = () => {
  const todos = [];
  return (
      <section>
        <h1>TodoList application</h1>
        <TodoForm/>
        <hr/>
        <TodoList todos={todos}/>
      </section>
  );
};

export default App;