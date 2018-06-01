import {CHANGE_QUERY, RECEIVE_REPOSITORIES, SUBMIT_QUERY} from "../actions";

const reducer = (state = {}, action) => {
  switch (action.type) {
    case CHANGE_QUERY:
      return Object.assign({}, state, {query: action.query});
    case SUBMIT_QUERY:
      return Object.assign({}, state, {processing: true});
    case RECEIVE_REPOSITORIES:
      return Object.assign({}, state, {repositories: action.repositories, processing: false});
    default:
      return state
  }
};

export default reducer;