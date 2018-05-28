import {CHANGE_QUERY} from "../actions";

const reducer = (state = {}, action) => {
  switch (action.type) {
    case CHANGE_QUERY:
      return Object.assign({}, state, {query: action.query});
    default:
      return state
  }
};

export default reducer;