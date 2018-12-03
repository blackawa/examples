<template>
  <div>
    <h1>Counter App</h1>
    <div>{{count}}</div>
    <p><button v-on:click="increment">Increment++</button></p>
  </div>
</template>

<script>
  export default {
    name: 'Counter',
    computed: {
      count() {
        return this.$store.state.count
      },
    },
    methods: {
      increment() {
        this.$store.commit('increment')
      }
    }
  }
</script>