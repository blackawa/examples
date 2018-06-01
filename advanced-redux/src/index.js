import React from 'react';
import {render} from 'react-dom';
import {applyMiddleware, createStore} from 'redux';
import reducers from './reducers';
import {Provider} from 'react-redux';
import App from "./components/App";
import thunkMiddleware from 'redux-thunk';

const store = createStore(
    reducers,
    applyMiddleware(
        thunkMiddleware
    )
);

render(
    <Provider store={store}>
      <App/>
    </Provider>,
    document.body
);
