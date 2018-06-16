import React from 'react';
import {render} from 'react-dom';
import {createStore, applyMiddleware, combineReducers} from 'redux';
import {Provider} from 'react-redux';
import {BrowserRouter} from 'react-router-dom';
import {createBrowserHistory} from 'history';
import {routerMiddleware, ConnectedRouter, routerReducer} from 'react-router-redux';
import createSagaMiddleware from 'redux-saga';
import App from './components/App';
import reducer from './reducers';
import saga from './sagas';

const browserHistory = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();
const store = createStore(
    combineReducers({reducer, router: routerReducer}),
    applyMiddleware(
        sagaMiddleware,
        routerMiddleware(browserHistory)
    )
);
sagaMiddleware.run(saga);

render(
    <Provider store={store}>
      <ConnectedRouter history={browserHistory}>
        <BrowserRouter>
          <App/>
        </BrowserRouter>
      </ConnectedRouter>
    </Provider>,
    document.getElementById('app')
);