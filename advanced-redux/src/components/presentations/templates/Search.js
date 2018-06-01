import React from 'react';
import SearchForm from "../organisms/SearchForm";
import SearchResult from "../organisms/SearchResult";

const Search = ({repositories, onChangeQuery, onSubmitQuery, query, processing}) => {
  return <div>
    <SearchForm onChangeQuery={onChangeQuery} query={query} onSubmit={onSubmitQuery} processing={processing}/>
    <SearchResult repositories={repositories}/>
  </div>
};

export default Search;