<template>
  <div>
    <h1>Sign up</h1>
    <h2>with email/password</h2>
    <div v-if="hasError">{{errorMessage}}</div>
    <div>
      <input type="email" name="email" placeholder="email" v-model="email"/>
      <input type="password" name="password" placeholder="password" v-model="password"/>
      <button v-on:click="signUpWithEmailPassword">Sign up</button>
    </div>
    <h2>with Google</h2>
    <button v-on:click="signUpWithGoogleAccount">Sign up with Google</button>
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
        },
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
      signUpWithEmailPassword() {
        this.$store.dispatch(
            'auth/signUpWithEmailAndPassword',
            {email: this.email, password: this.password}
        )
        .then(() => {
          this.$router.push('/')
        })
        .catch((e) => {
          this.error.code = e.code
          this.error.message = e.message
        })
      },
      signUpWithGoogleAccount() {
        // TODO: call action
      }
    }
  }
</script>