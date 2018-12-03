<template>
  <div id="app">
    <Header/>
    <router-view/>
  </div>
</template>

<script>
  import Header from "./components/Header";
  import {auth} from './firebase'

  export default {
    name: 'app',
    components: {
      Header,
    },
    async mounted() {
      let credential
      if (!this.credential) credential = await auth()
      await Promise.all([
          this.credential ? Promise.resolve() : this.$store.commit('auth/setCredential', credential)
      ])
    },
    computed: {
      credential() {
        return this.$store.state.auth.credential
      }
    }
  }
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
