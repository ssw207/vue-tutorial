<template>
  <li>
    {{ todo.text }}
    <!-- 버튼 클릭시 부모에서 remove이벤트 감지 -->
    <button @click="$emit('remove', todo.id)">X</button>
  </li>
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
