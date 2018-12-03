<template>
  <div>
    // TODO: use FinalForm
    <form v-on:onsubmit="createDocument">

    </form>
  </div>
</template>

<script>
  export default {
    name: 'Form',
    methods: {
      createDocument() {
        // TODO: call action to save to db
      }
    }
  }
</script>