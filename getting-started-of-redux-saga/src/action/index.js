export const CHANGE_TODO = 'CHANGE_TODO';
export const ADD_TODO = 'ADD_TODO';

export function addTodo(title) {
  return {type: ADD_TODO, title}
}

export function changeTodo(title) {
  return {type: CHANGE_TODO, title}
}