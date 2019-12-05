<template>
  <b-list-group-item class="d-flex justify-content-between align-items-center">
    <b-form-checkbox type="checkbox" v-model="todo.done">
      <span>{{ todo.title }}</span>
    </b-form-checkbox>
    <b-button
      size="sm"
      variant="outline-primary"
      @click="$emit('delete', todo.id)"
      >삭제</b-button
    >
  </b-list-group-item>
</template>

<script>
export default {
  props: {
    todo: {
      type: Object,
      required: true
    }
  }
};
</script>

<style></style>
