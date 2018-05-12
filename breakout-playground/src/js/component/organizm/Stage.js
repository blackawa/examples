import React from 'react';
import Blocks from '../molecule/Blocks';
import Ball from '../atom/Ball';

const Stage = () => {
  return (
      <div>
        <Blocks/>
        {/*位置はstoreから取得したBallのx,y座標を使ってこのコンポーネントで調整する*/}
        <Ball/>
      </div>
  );
};

export default Stage;