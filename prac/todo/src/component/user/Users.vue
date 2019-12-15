<template>
  <div>
    <ul v-if="users.length">
      <li v-for="user of users" :key="user.id">{{user.id}} {{user.name}}</li>
    </ul>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  data: function() {
    return {
      users: []
    };
  },
  created: function() {
    // 유저리스트
    // axios.get("../../data/users.json").then(res => {
    //   this.users = res.data;
    // });
  }
};
</script>

<style>
</style>