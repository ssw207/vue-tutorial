<template>
  <li>{{ todo.text }}<button v-on:click="remove">X</button></li>
</template>

<script>
export default {
  props: {
    todo: Object
  },
  methods: {
    remove: function() {
      this.$emit("remove", this.todo.id);
    }
  }
};
</script>

<style></style>
