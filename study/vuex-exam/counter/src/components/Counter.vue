<template>
  <div>
    {{ this.$store.state.count }}
    <button @click="inc">+</button>
    <button @click="dec">-</button>
  </div>
</template>

<script>
export default {
  methods: {
    inc() {
      this.$store.commit("inc", { count: 1 });
    },
    dec() {
      this.$store.commit("dec", { count: 1 });
    }
  }
};
</script>

<style></style>
