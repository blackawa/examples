import React from 'react';
import {render} from 'react-dom';
import {createStore, applyMiddleware, compose} from 'redux';
import {Provider} from 'react-redux';
import {BrowserRouter} from 'react-router-dom';
import {createBrowserHistory} from 'history';
import {connectRouter, routerMiddleware, ConnectedRouter} from 'connected-react-router';
import createSagaMiddleware from 'redux-saga';
import App from './components/App';
import reducer from './reducers';
import saga from './sagas';

const history = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();
const store = createStore(
    connectRouter(history)(reducer),
    compose(
        applyMiddleware(routerMiddleware(history)),
        applyMiddleware(sagaMiddleware)
    )
);
sagaMiddleware.run(saga);

render(
    <Provider store={store}>
      <ConnectedRouter history={history}>
        <BrowserRouter>
          <App/>
        </BrowserRouter>
      </ConnectedRouter>
    </Provider>,
    document.getElementById('app')
);