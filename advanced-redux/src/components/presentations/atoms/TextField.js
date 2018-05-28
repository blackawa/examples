import React from 'react';

const style = {
  fontSize: '.9rem',
  padding: '.25rem',
};

const TextField = ({placeholder, value, onChange}) => {
  return <input style={style} type='text' placeholder={placeholder}
         value={value || ''} onChange={(e) => onChange(e.target.value)}/>
};

export default TextField;