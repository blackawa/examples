import {CHANGE_QUERY, SUBMIT_QUERY} from "../actions";

const reducer = (state = {}, action) => {
  switch (action.type) {
    case CHANGE_QUERY:
      return Object.assign({}, state, {query: action.query});
    case SUBMIT_QUERY:
      return Object.assign({}, state, {processing: true});
    default:
      return state
  }
};

export default reducer;