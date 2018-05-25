import React from 'react';

const style = {
  fontSize: '.9rem',
  padding: '.25rem',
};

const TextField = ({placeholder, value, onChange}) => <input style={style} type='text' placeholder={placeholder} value={value || ''} onChange={onChange}/>;

export default TextField;