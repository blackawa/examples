import React from 'react';
import SearchForm from "../organisms/SearchForm";
import SearchResult from "../organisms/SearchResult";

const Search = ({repositories, onChangeQuery, query}) => {
  return <div>
    <SearchForm onChangeQuery={onChangeQuery} query={query}/>
    <SearchResult/>
  </div>
};

export default Search;