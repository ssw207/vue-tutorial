<template>
  <div id="app">
    <Header></Header>
    <main>
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
import Header from "./component/Header";
export default {
  name: "app",
  components: {
    Header
  }
};
</script>
