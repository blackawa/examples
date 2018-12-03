import Vue from 'vue'
import Vuex from 'vuex'
import counter from './counter'
import todos from './todos'

// activate Vuex
Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    counter,
    todos,
  }
});