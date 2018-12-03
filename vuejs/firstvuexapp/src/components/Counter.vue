<template>
  <div class="wrapper">
    <h1>カウンター</h1>
    <button class="decrement" v-on:click="decrement">-</button>
    <span class="count">{{count}}</span>
    <button class="increment" v-on:click="increment">+</button>
  </div>
</template>

<script>
  export default {
    name: 'Counter',
    computed: {
      count() {
        return this.$store.state.counter.count
      }
    },
    methods: {
      decrement() {
        this.$store.commit('decrement')
      },
      increment() {
        this.$store.commit('increment')
      }
    }
  }
</script>

<style scoped>
  .wrapper {
    margin: 3rem 0;
    text-align: left;
  }
  .decrement {
    margin-right: 1rem;
  }
  .increment {
    margin-left: 1rem;
  }
</style>