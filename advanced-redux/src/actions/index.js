import fetch from 'cross-fetch';

const URI = require('urijs');

export const CHANGE_QUERY = 'CHANGE_QUERY';
export const changeQuery = (query) => {
  return {type: CHANGE_QUERY, query: query}
};

export const SUBMIT_QUERY = 'SUBMIT_QUERY';
export const submitQuery = () => {
  return {type: SUBMIT_QUERY}
};

export const RECEIVE_REPOSITORIES = 'RECEIVE_REPOSITORIES';
export const receiveRepositories = (repositories) => {
  return {type: RECEIVE_REPOSITORIES, repositories: repositories}
};

export const fetchRepositories = (query) => {
  console.log('request');
  return (dispatch) => {
    const requestUrl = new URI('https://api.github.com/search/repositories')
        .query({q: query});
    return fetch(requestUrl)
        .then(
            res => res.json(),
            error => console.error('An error occurred.', error)
        )
        .then(json => dispatch(receiveRepositories(json)));
  }
};