import React from 'react';
import SingleTextForm from "../molecules/SingleTextForm";

const SearchForm = ({onChangeQuery, onSubmit, query}) => {
  return <div>
    <h1>リポジトリを探す:</h1>
    <SingleTextForm onChangeQuery={onChangeQuery} onSubmit={onSubmit} value={query}/>
  </div>
};

export default SearchForm;