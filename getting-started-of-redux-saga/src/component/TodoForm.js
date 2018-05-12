import React from 'react';
import {connect} from 'react-redux';
import {addTodo, changeTodo} from "../action";

const TodoForm = (props) => {
  return (
      <form onSubmit={(e) => {
        e.preventDefault();
        props.dispatch(addTodo(props.form));
        props.dispatch(changeTodo(''));
      }}>
        <label>New Todo</label>
        <input type={'text'} onChange={(e) => {
          props.dispatch(changeTodo(e.target.value));
        }} placeholder={'Type something you have to do.'}/>
        <button type={'submit'}>Create</button>
      </form>
  );
};

export default connect(state => state)(TodoForm);