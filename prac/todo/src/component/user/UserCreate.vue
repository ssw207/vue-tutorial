<template>
  <div id="form">
    <b-card bg-variant="light">
      <b-form-group label="회원가입" label-size="lg" label-class="font-weight-bold pt-0">
        <b-form-group label="ID:" label-for="nested-id">
          <b-form-input id="nested-id" v-model="id"></b-form-input>
        </b-form-group>

        <b-form-group label="Password:" label-for="nested-password">
          <b-form-input id="nested-password" v-model="password"></b-form-input>
        </b-form-group>

        <b-form-group label="Name:" label-for="nested-name">
          <b-form-input id="nested-name" v-model="userName"></b-form-input>
        </b-form-group>
      </b-form-group>
      <div>
        <div class="btn-box">
          <b-button variant="success" @click="userCrate">저장</b-button>
          <b-button class="mg-left" variant="danger" @click="$router.go(-1)">취소</b-button>
        </div>
      </div>
    </b-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data: function() {
    return {
      id: "",
      password: "",
      userName: ""
    };
  },
  methods: {
    userCrate() {
      let data = {
        memId: this.id,
        memPw: this.password,
        userName: this.userName
      };

      axios
        .post("http://localhost:8081/api/member/save", data)
        .then(() => {
          alert("회원가입 성공");
          this.$router.push("/user/login");
        })
        .catch(function(error) {
          alert(error);
        });
    }
  }
};
</script>
<style scoped>
#form {
  margin-top: 20%;
  margin: auto;
  width: 40%;
}
.btn-box {
  margin: auto;
  width: 50%;
}
.mg-left {
  margin-left: 30%;
}
</style>