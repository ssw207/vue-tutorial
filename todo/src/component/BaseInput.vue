<template>
  <b-row class="my-1" align="left">
    <b-col sm="10"><b-form-input @keydown.enter="add" v-model="text" /> </b-col>
    <b-col sm="2">
      <b-button variant="success" @click="add">추가</b-button></b-col
    >
  </b-row>
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
