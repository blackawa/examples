import React from 'react';
import SingleTextForm from "../molecules/SingleTextForm";

const SearchForm = ({onSubmit}) => <div>
  <h1>リポジトリを探す:</h1>
  <SingleTextForm onSubmit={onSubmit}/>
</div>;

export default SearchForm;