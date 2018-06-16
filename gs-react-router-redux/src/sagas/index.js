import {put} from 'redux-saga/effects';
import {push} from 'connected-react-router';

function* goToChildren(action) {
  yield put(push('/children'));
}

function* rootSaga () {
}

export default rootSaga;