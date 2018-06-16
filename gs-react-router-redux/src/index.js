import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import {BrowserRouter} from 'react-router-dom';
import {ConnectedRouter} from 'react-router-redux';
import {PersistGate} from 'redux-persist/integration/react';
import App from './components/App';
import saga from './sagas';
import store, {runSaga, persistor, browserHistory} from './store';

runSaga(saga);

render(
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <ConnectedRouter history={browserHistory}>
          <App/>
        </ConnectedRouter>
      </PersistGate>
    </Provider>,
    document.getElementById('app')
);