import React from 'react';
import {Link} from 'react-router-dom';
import {connect} from 'react-redux';
import {push} from 'react-router-redux';
import {withRouter} from 'react-router-dom';

const mapStateToProps = (state) => {
  return {state}
};

const mapDispatchToProps = (dispatch) => {
  return {
    goToChildren: e => dispatch(push('/children'))
  };
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(({state, goToChildren}) => {
  return <div>
    <h1>This is /inheritee view</h1>
    <Link to='/children'>Go to children</Link>
    <button onClick={goToChildren}>ボタンを押すとpushをdispatchして画面遷移します</button>
    <div>
      <h2>Current state:</h2>
      <pre>{JSON.stringify(state)}</pre>
    </div>
  </div>
}));
