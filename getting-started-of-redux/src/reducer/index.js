import {CHANGE_TEXT} from "../action";

const initialState = {text: ''};

export default function simpleApp(state = initialState, action) {
  switch (action.type) {
    case CHANGE_TEXT:
      return Object.assign({}, state, {text: action.text});
    default:
      return state;
  }
}
