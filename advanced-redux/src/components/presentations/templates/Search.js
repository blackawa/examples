import React from 'react';
import SearchForm from "../organisms/SearchForm";
import SearchResult from "../organisms/SearchResult";

const Search = ({repositories}) => <div>
  <SearchForm/>
  <SearchResult/>
</div>;

export default Search;