<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="#">TODO</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item v-if="isLogin" href="#">TODO 리스트</b-nav-item>
          <b-nav-item v-if="isLogin" href="#">게시판</b-nav-item>
          <b-nav-item-dropdown v-if="isAdmin" text="관리자페이지">
            <b-dropdown-item @click="go('/user/users')">회원 리스트</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown v-if="true" right>
            <!-- Using 'button-content' slot -->
            <template v-slot:button-content>
              <em>사용자</em>
            </template>
            <b-dropdown-item @click="$router.push('/user/')">회원정보</b-dropdown-item>
            <b-dropdown-item href="#">로그아웃</b-dropdown-item>
          </b-nav-item-dropdown>
          <b-nav-item v-if="!isLogin" @click="go('/user/login')">로그인</b-nav-item>
          <b-nav-item v-if="!isLogin" @click="go('/user/create')">회원가입</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isLogin: false,
      isAdmin: true
    };
  },
  methods: {
    go(url) {
      this.$router.push(url);
    }
  }
};
</script>

<style>
</style>