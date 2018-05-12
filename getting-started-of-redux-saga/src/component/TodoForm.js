import React from 'react';

const TodoForm = () => {
  return (
      <form onSubmit={(e) => e.preventDefault()}>
        <label>New Todo</label>
        <input type={'text'} onChange={(e) => console.log(e)} placeholder={'Type something you have to do.'}/>
        <button type={'submit'}>Create</button>
      </form>
  );
};

export default TodoForm;