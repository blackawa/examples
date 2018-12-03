<template>
  <div class="wrapper">
    <div class="done"><input type="checkbox" :checked="todo.done" v-on:click="$emit('toggleTodoStatus', todo.id)"></div>
    <div class="title">{{ todo.title }}</div>
    <div class="actions"><button v-on:click="$emit('deleteTodo', todo.id)">Delete</button></div>
  </div>
</template>

<script>
  export default {
    name: 'Todo',
    props: ['todo'],
  }
</script>

<style scoped>
  .wrapper {
    display: flex;
  }
  .actions {
    margin-left: auto;
  }
</style>