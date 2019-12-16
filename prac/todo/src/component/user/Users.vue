<template>
  <div>
    <ul v-if="users.length">
      <li v-for="user of users" :key="user.id">{{user.memId}} {{user.nmName}}</li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data: function() {
    return {
      users: []
    };
  },
  created: function() {
    axios.get("http://localhost:8081/api/member/list").then(res => {
      this.users = res.data;
    });
  }
};
</script>

<style>
</style>