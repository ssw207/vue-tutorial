<template>
  <div>{{user.memId}}</div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      loading: false,
      user: null
    };
  },
  methods: {
    fetchData() {
      this.loading = true;
      const id = this.$route.query.memId;
      this.getUser(id);
    },
    getUser(id) {
      axios
        .get(`http://localhost:8081/api/info/${id}`)
        .then(res => {
          this.user = res.data;
        })
        .catch(error => {
          alert(error);
        });
    }
  }
};
</script>

<style>
</style>