<template>
  <div class="wrapper" v-on:deleteTodo="deleteTodo">
    <h1>Todo List</h1>
    <div class="statistics">
      <p>Done: {{ todos.filter((t) => t.done).length }}</p>
    </div>
    <Todo v-for="todo in todos"
          :key="todo.id"
          v-bind:todo="todo"
          v-on:deleteTodo="deleteTodo"
          v-on:toggleTodoStatus="toggleTodoStatus"/>
    <AddTodo v-on:createTodo="createTodo"/>
  </div>
</template>

<script>
  import Todo from './Todo';
  import AddTodo from "./AddTodo";

  export default {
    name: 'TodoList',
    data: () => {
      return {
        todos: [
          {
            id: 2,
            done: true,
            title: 'vue.jsアプリを起動する',
          },
          {
            id: 1,
            done: false,
            title: 'ローカルステートを使いこなす',
          },
        ],
      }
    },
    components: {
      AddTodo,
      Todo,
    },
    methods: {
      // アロー関数を使うとthisが取れなくて死ぬ
      deleteTodo(id) {
        this.todos = this.todos.filter(t => t.id !== id)
      },
      toggleTodoStatus(id) {
        this.todos = this.todos.map(t => t.id === id ? Object.assign({}, t, {done: !t.done}) : t)
      },
      createTodo(title) {
        this.todos.splice(0, 0, {id: this.todos.length + 1, done: false, title: title})
      },
    },
  }
</script>

<style scoped>
  div.wrapper {
    padding: 0 3rem;
    text-align: left;
  }
</style>