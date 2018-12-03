import firebase from 'firebase'

if (!firebase.apps.length) {
  firebase.initializeApp({
    apiKey: "AIzaSyAfQxQONvOkFPT1BnhCDBAPk7NPKbAyvoI",
    authDomain: "vuexfirebaseauth-trial.firebaseapp.com",
    databaseURL: "https://vuexfirebaseauth-trial.firebaseio.com",
    projectId: "vuexfirebaseauth-trial",
    storageBucket: "vuexfirebaseauth-trial.appspot.com",
    messagingSenderId: "262491038766"
  });
}

export function auth() {
  return new Promise((resolve) => {
    // eslint-disable-next-line
    console.log('waiting for auth state change')
    firebase.auth().onAuthStateChanged((user) => {
      // eslint-disable-next-line
      console.log('detect auth state change!!!')
      resolve(user || false)
    })
  })
}

export default firebase;
