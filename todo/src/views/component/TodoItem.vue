<template>
  <p>
    <el-col>
      <el-checkbox type="checkbox" v-model="todo.done" @change="$emit('check', todo)">
        <span>{{ todo.title }}</span>
      </el-checkbox>
    </el-col>
    <el-col>
      <el-button size="sm" variant="outline-primary" @click="$emit('delete', todo.id)">삭제</el-button>
    </el-col>
  </p>
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
