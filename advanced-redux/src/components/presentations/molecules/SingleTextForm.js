import React from 'react';
import TextField from "../atoms/TextField";
import Button from "../atoms/Button";

const SingleTextForm = ({onChangeQuery, onSubmit, value}) => {
  return <form onSubmit={onSubmit}>
    <TextField placeholder='検索キーワード' onChange={onChangeQuery} value={value}/>
    <Button label='検索'/>
  </form>
};

export default SingleTextForm;