export const CHANGE_QUERY = 'CHANGE_QUERY';
export const changeQuery = (query) => {
  return {type: CHANGE_QUERY, query: query}
};