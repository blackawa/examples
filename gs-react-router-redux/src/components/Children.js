import React from 'react';
import {Link} from 'react-router-dom';
import {connect} from 'react-redux';
import {withRouter} from 'react-router-dom';

const mapStateToProps = (state) => {
  return {state};
};

const mapDispatchToProps = (dispatch) => {return {}};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(({history, state}) => {
  return <div>
    <h1>This is /children view</h1>
    <Link to='/inheritee'>Back to inheritee</Link>
    <div>
      <h2>Current state:</h2>
      <pre>{JSON.stringify(state)}</pre>
    </div>
  </div>
}));