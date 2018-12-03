<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <Counter/>
    <Todos/>
  </div>
</template>

<script>
import Counter from "./components/Counter";
import Todos from "./components/Todos";

export default {
  name: 'app',
  components: {Todos, Counter},
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
