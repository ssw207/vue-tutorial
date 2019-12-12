<template>
  <div>
    <b-form-group
      label-for="input-id"
      :invalid-feedback="invalidFeedbackId"
      :valid-feedback="validFeedbackId"
      :state="stateId"
    >
      <b-form-input id="input-id" placeholder="ID" v-model="id" :state="stateId" trim></b-form-input>
    </b-form-group>
    <b-form-group label-for="input-password">
      <b-form-input id="input-password" placeholder="PASSWORD" v-model="password" trim></b-form-input>
    </b-form-group>
  </div>
</template>

<script>
export default {
  computed: {
    stateId() {
      return this.id.length >= 4 ? true : false;
    },
    invalidFeedbackId() {
      if (this.state) {
        return "";
      } else if (this.id.length > 0) {
        return "최소 4글자 이상 입력해 주세요";
      } else {
        return "값을 입력해주세요";
      }
    },
    validFeedbackId() {
      return this.state === true ? "정상 입니다" : "";
    },

    statePasswordId() {
      return this.password.length >= 8 ? true : false;
    }
  },
  data() {
    return {
      id: "",
      password: ""
    };
  }
};
</script>

<style>
</style>