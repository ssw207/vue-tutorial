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
      users: [
        {
          id: "admin",
          name: "홍길동",
          password: "1234"
        },
        {
          id: "admin1",
          name: "홍길동1",
          password: "1234"
        },
        {
          id: "admin2",
          name: "홍길동2",
          password: "1234"
        },
        {
          id: "admin3",
          name: "홍길동3",
          password: "1234"
        }
      ]
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