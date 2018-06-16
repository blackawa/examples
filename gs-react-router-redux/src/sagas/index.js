import {put} from 'redux-saga/effects';
import {push} from 'react-router-redux';

function* goToChildren(action) {
  yield put(push('/children'));
}

function* rootSaga () {
}

export default rootSaga;