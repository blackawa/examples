import React from 'react';
import {connect} from 'react-redux';
import TextField from './TextField';
import PreviewField from './PreviewField';
import {changeText} from '../action';

const App = ({text, onTextChange}) => {
  return (
      <div>
        <h2>Bidirectional Data Binding Example</h2>
        <TextField value={text} onChange={onTextChange}/>
        <PreviewField text={text}/>
      </div>
  )
};

const mapStateToProps = state => {
  return {
    text: state.text
  }
};

const mapDispatchToProps = dispatch => {
  return {
    onTextChange: e => {
      dispatch(changeText(e))
    }
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);