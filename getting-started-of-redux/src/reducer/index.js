import {CHANGE_TEXT} from "../action";

export const app = (state = {}, action) => {
  switch (action.type) {
    case CHANGE_TEXT:
      console.log('change text to ' + action.text);
      return Object.assign({}, state, {text: action.text});
    default:
      return state;
  }
};
