import firebase from 'firebase'

export default {
  namespaced: true,
  state: {
    // 認証情報をまるっと格納する
    initializing: true,
    credential: null,
  },
  getters: {
    status: state => {
      if (state.initializing) {
        return 'INITIALIZING'
      } else if (state.credential !== null) {
        return 'AUTHENTICATED'
      } else {
        return 'UNKNOWN'
      }
    }
  },
  mutations: {
    setCredential: (state, payload) => {
      state.initializing = false
      state.credential = payload || null
    },
  },
  actions: {
    signUpWithEmailAndPassword(_, {email, password}) {
      return firebase.auth().createUserWithEmailAndPassword(email, password)
    },
    signInWithEmailAndPassword(_, {email, password}) {
      return firebase.auth().signInWithEmailAndPassword(email, password)
    },
    signOut(context) {
      firebase.auth().signOut()
      .then(() => {
        context.commit('auth/setCredential')
      })
    }
  },
}