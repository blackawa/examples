import { applyMiddleware, createStore } from 'redux'
import { createLogger } from 'redux-logger'
import createBrowserHistory from 'history/createBrowserHistory'
import { syncHistoryWithStore, routerReducer, routerMiddleware } from 'react-router-redux'
import { persistStore, persistReducer } from 'redux-persist'
import  storage from 'redux-persist/lib/storage'
import createSagaMiddleware from 'redux-saga'
import reducer from '../reducers'

export const browserHistory = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();

const persistConfig = {
  key: 'root',
  storage,
  whitelist: ['slide']
};

const persistedReducer = persistReducer(persistConfig, reducer)

const store = createStore(
    persistedReducer,
    applyMiddleware(
        sagaMiddleware,
        routerMiddleware(browserHistory),
        createLogger()));

export const persistor = persistStore(store);
export const runSaga = sagaMiddleware.run;

export default store
