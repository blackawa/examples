<template>
  <div class="wrapper">
    <h1>Todoリスト</h1>
    <div class="statistics">
      <p>Count: {{todoCount}}</p>
      <p>Done: {{doneTodoCount}}</p>
    </div>
    <Todo v-for="todo in todos" :key="todo.id" v-bind:item="todo"/>
    <div class="create">
      <input type="text" v-model="newTodoTitle">
      <button v-on:click="createTodo">Add Todo</button>
    </div>
  </div>
</template>

<script>
  import Todo from "./Todo";
  export default {
    name: 'Todos',
    data: () => {
      return {
        newTodoTitle: '',
      }
    },
    components: {Todo},
    computed: {
      todos() {
        return this.$store.state.todos.items
      },
      todoCount() {
        return this.$store.state.todos.items.length
      },
      doneTodoCount() {
        return this.$store.getters.doneTodoCount
      },
    },
    methods: {
      createTodo() {
        this.$store.commit('create', {done: false, title: this.newTodoTitle})
        this.newTodoTitle = ''
      }
    }
  }
</script>

<style scoped>
  .wrapper {
    margin: 3rem 0;
    text-align: left;
  }
</style>