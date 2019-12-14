/* 메인 템플릿 */
<template>
  <div>
    <h1>Todo 리스트</h1>
    <TodoList />
  </div>
</template>

<script>
import TodoList from "./components/TodoList.vue";

//템플릿의 vue인스턴스 옵션
export default {
  // 등록된 컴포넌트는 위의 템플릿 태그에서 사용가능
  components: {
    TodoList
  }
};
</script>

<style></style>
