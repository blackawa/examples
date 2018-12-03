<template>
  <div>
    <span v-if="signInStatus === 'INITIALIZING'">
      Initializing user status
    </span>
    <span v-else-if="signInStatus === 'AUTHENTICATED'">
      <button v-on:click="signOut">Sign out</button>
    </span>
    <span v-else>
      <router-link to="/sign-up">Sign up</router-link><span>/</span>
      <router-link to="/sign-in">Sign in</router-link>
    </span>
  </div>
</template>

<script>
  export default {
    name: 'Header',
    computed: {
      signInStatus() {
        return this.$store.getters['auth/status']
      }
    },
    methods: {
      signOut() {
        this.$store.dispatch('auth/signOut')
        .then(() => {
          this.$router.push('/')
        })
        .catch((e) => {
          // eslint-disable-next-line
          console.error(e)
        })
      }
    },
  }
</script>