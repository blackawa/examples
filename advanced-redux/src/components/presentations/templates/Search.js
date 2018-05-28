import React from 'react';
import SearchForm from "../organisms/SearchForm";
import SearchResult from "../organisms/SearchResult";

const Search = ({repositories, onChangeQuery, onSubmitQuery, query}) => {
  return <div>
    <SearchForm onChangeQuery={onChangeQuery} query={query} onSubmit={onSubmitQuery}/>
    <SearchResult repositories={repositories}/>
  </div>
};

export default Search;