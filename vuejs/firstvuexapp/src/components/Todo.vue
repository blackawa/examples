<template>
  <div class="wrapper">
    <label :for="`todoItem${item.id}`">
      <input type="checkbox" :id="`todoItem${item.id}`" :checked="item.done" v-on:click="toggleItemStatus">
      <span>{{item.title}}</span>
    </label>
    <button class="delete" v-on:click="deleteItem">Delete</button>
  </div>
</template>

<script>
  export default {
    name: 'Todo',
    props: ['item'],
    methods: {
      toggleItemStatus() {
        this.$store.commit('update', Object.assign({}, this.item, {done: !this.item.done}))
      },
      deleteItem() {
        this.$store.commit('delete', this.item.id)
      }
    }
  }
</script>

<style scoped>
  .delete {
    margin-left: 2rem;
  }
</style>