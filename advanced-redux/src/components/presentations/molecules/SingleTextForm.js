import React from 'react';
import TextField from "../atoms/TextField";
import Button from "../atoms/Button";

const SingleTextForm = ({onSubmit}) => <form onSubmit={onSubmit}>
  <TextField placeholder='検索キーワード'/>
  <Button label='検索'/>
</form>;

export default SingleTextForm;