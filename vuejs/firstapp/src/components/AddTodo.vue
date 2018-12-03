<template>
  <div>
    <input type="text" name="title" v-model="title">
    <button v-on:click="createTodo">Add Todo</button>
  </div>
</template>

<script>
  export default {
    name: 'AddTodo',
    data: () => {
      return {
        title: '',
      }
    },
    methods: {
      createTodo() {
        this.$emit('createTodo', this.title)
        this.title = ''
      }
    }
  }
</script>

<style scoped>
</style>