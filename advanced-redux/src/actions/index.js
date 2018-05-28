export const CHANGE_QUERY = 'CHANGE_QUERY';
export const changeQuery = (query) => {
  return {type: CHANGE_QUERY, query: query}
};

export const SUBMIT_QUERY = 'SUBMIT_QUERY';
export const submitQuery = (query) => {
  return {type: SUBMIT_QUERY, query: query}
};

export const RECEIVE_REPOSITORIES = 'RECEIVE_REPOSITORIES';
export const receiveRepositories = (repositories) => {
  return {type: RECEIVE_REPOSITORIES, repositories: repositories}
};