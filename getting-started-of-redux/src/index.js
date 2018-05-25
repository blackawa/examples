import React from 'react';
import {render} from 'react-dom';
import App from './component/App';
import {Provider} from 'react-redux';
import {app} from './reducer';
import {createStore} from 'redux';

const store = createStore(app);

render(
    <Provider store={store}>
      <App/>
    </Provider>,
    document.getElementById('app')
);
