<template>
  <el-row :gutter="20">
    <el-col :span="6">
      <el-input placeholder="할 일 을 적으세요" @keydown.enter="add" v-model="text" />
    </el-col>
    <el-col>
      <el-button variant="success" @click="add">추가</el-button>
    </el-col>
  </el-row>
</template>

<script>
export default {
  data: function() {
    return {
      text: ""
    };
  },
  methods: {
    add: function() {
      this.$emit("add", this.text);
      this.text = "";
    }
  }
};
</script>

<style></style>
