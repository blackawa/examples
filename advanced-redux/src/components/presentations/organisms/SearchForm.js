import React from 'react';
import SingleTextForm from "../molecules/SingleTextForm";

const SearchForm = ({onChangeQuery, onSubmit, query, processing}) => {
  const processingMessage = processing ? <p>検索中...</p> : null;
  return <div>
    <h1>リポジトリを探す:</h1>
    <SingleTextForm onChangeQuery={onChangeQuery} onSubmit={onSubmit} value={query}/>
    {processing}
    {processingMessage}
  </div>
};

export default SearchForm;