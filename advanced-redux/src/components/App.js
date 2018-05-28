import React from 'react';
import {connect} from 'react-redux';
import {changeQuery} from "../actions";
import Search from "./presentations/templates/Search";

const App = ({onChangeQuery, repositories, query}) => {
  return <Search repositories={repositories}
                 onChangeQuery={onChangeQuery}
                 query={query}/>
};

const mapStateToProps = (state) => {
  return {
    repositories: state.repositories,
    query: state.query
  }
};

const mapDispatchToProps = (dispatch) => {
  return {
    onChangeQuery: (query) => dispatch(changeQuery(query)),
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);