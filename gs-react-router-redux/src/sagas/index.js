import {put, takeLatest} from 'redux-saga/effects';
import {push} from 'react-router-redux';
import {GO_TO_CHILDREN} from "../actions";

function* goToChildren(action) {
  yield put(push('/children'));
}

function* rootSaga () {
  yield takeLatest(GO_TO_CHILDREN, goToChildren)
}

export default rootSaga;