/* 문자열 입력후 엔터 클릭시 insertList 이벤트 실행 */
<template>
  <input type="text" class="input" :value="value" v-on="listeners" />
</template>

<script>
export default {
  //부모 컴포넌트의 값 전달
  props: {
    value: {
      type: String,
      default: ""
    }
  },
  computed: {
    listeners() {
      return {
        ...this.$listeners, // 부모의 v-on이벤트들을 동일하게 등록
        input: event => this.$emit("input", event.target.value) // input이벤트를 오버라이드
      };
    }
  }
};
</script>

<style>
.input {
  width: 100%;
  padding: 8px 10px;
  border: 1px solid;
}
</style>
