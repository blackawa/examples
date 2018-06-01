import React from 'react';
import {connect} from 'react-redux';
import {changeQuery, fetchRepositories} from "../actions";
import Search from "./presentations/templates/Search";

const App = ({onChangeQuery, onSubmitQuery, repositories, query, processing}) => {
  return <Search repositories={repositories}
                 onChangeQuery={onChangeQuery}
                 onSubmitQuery={onSubmitQuery}
                 query={query}
                 processing={processing}/>
};

const mapStateToProps = (state) => {
  return {
    repositories: state.repositories,
    query: state.query,
    processing: state.processing,
  }
};

const mapDispatchToProps = (dispatch) => {
  return {
    onChangeQuery: (query) => dispatch(changeQuery(query)),
    onSubmitQuery: (query) => dispatch(fetchRepositories(query))
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);