<template>
  <div>
    <h1>Sign in</h1>
    <h2>with email/password</h2>
    <div v-if="hasError">{{errorMessage}}</div>
    <div>
      <input type="email" placeholder="email" v-model="email"/>
      <input type="password" placeholder="password" v-model="password"/>
      <button v-on:click="signInWithEmailPassword">Sign in</button>
    </div>
    <h2>with Google</h2>
    <button v-on:click="signInWithGoogleAccount">Sign in with Google</button>
  </div>
</template>

<script>
  export default {
    name: 'SignIn',
    data: () => {
      return {
        email: '',
        password: '',
        error: {
          code: '',
          message: '',
        }
      }
    },
    computed: {
      hasError() {
        return this.error.code.length > 0
      },
      errorMessage() {
        return `code: ${this.error.code} / message: ${this.error.message}`
      }
    },
    methods: {
      signInWithEmailPassword() {
        this.$store.dispatch('auth/signInWithEmailAndPassword', {
          email: this.email,
          password: this.password,
        })
        .then(() => {
          this.$router.push('/')
        })
        .catch(({code, message}) => {
          this.error.code = code
          this.error.message = message
        })
      },
      signInWithGoogleAccount() {
        // TODO: call action
      }
    }
  }
</script>