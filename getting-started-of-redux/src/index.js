import React from 'react';
import {render} from 'react-dom';
import {createStore} from 'redux';
import {Provider} from 'react-redux';

import App from './component/App';
import simpleApp from './reducer';

const store = createStore(simpleApp);

render(
    <Provider store={store}><App/></Provider>,
    document.getElementById('app')
);
