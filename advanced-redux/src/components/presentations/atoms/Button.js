import React from 'react';
import Radium from 'radium';

const style = {
  fontSize: '.9rem',
  padding: '.5rem .7rem',
  backgroundColor: 'hsla(170, 75%, 50%, 1)',
  color: '#fff',
  border: 'none',
  ':hover': {
    backgroundColor: 'hsla(170, 75%, 40%, 1)',
  },
  ':focus': {
    backgroundColor: 'hsla(170, 75%, 60%, 1)',
  },
  ':active': {
    backgroundColor: 'hsla(170, 75%, 70%, 1)',
  },
};

const Button = ({label, onClick}) => <button style={style} onClick={onClick}>
  {label}
</button>;

export default Radium(Button);