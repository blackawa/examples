import React from 'react';
import {render} from 'react-dom';

const Page1 = () => <div>
  <div className='tabs'>
    <ul>
      <li className='is-active'><a>Page 1</a></li>
      <li><a>Page 2</a></li>
    </ul>
  </div>
  <div className='content'>This is Page1!</div>
</div>;

const Page2 = () => <div>
  <div className='tabs'>
    <ul>
      <li><a>Page 1</a></li>
      <li className='is-active'><a>Page 2</a></li>
    </ul>
  </div>
  <div className='content'>This is Page2.</div>
</div>;

const App = () => <section className='section'>
  <div className='container'>
    <Page1/>
  </div>
</section>;

render(<App/>, document.getElementById('app'));
