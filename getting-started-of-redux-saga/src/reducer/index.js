import {ADD_TODO, CHANGE_TODO} from '../action';

function todos(state = {todos: []}, action) {
  switch (action.type) {
    case ADD_TODO:
      state.todos = [...state.todos, {title: action.title}];
      return state;
    case CHANGE_TODO:
      console.log(state.todos);
      return state;
    default:
      return state;
  }
}

export default todos;