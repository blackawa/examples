import Vue from 'vue'
import Vuex from 'vuex'
import auth from './auth'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    auth,
  },
  state: {
    count: 0,
  },
  mutations: {
    increment(state) {
      state.count++
    }
  },
})