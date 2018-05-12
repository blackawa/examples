import React from 'react';
import Block from '../atom/Block';

const Blocks = () => {
  // 本来はstoreから取得する
  const blockTable = ['o', 'o', 'o', 'o', 'o'];

  const blocks = [];

  for (let block in blockTable) {
    blocks.push(<Block/>);
  }

  return (<div>{blocks}</div>);
};

export default Blocks;