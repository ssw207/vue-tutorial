<template>
  <p>{{greeting}} world!</p>
</template>

<script>
module.export = {
  data: function() {
    return {
      greeting: "hello"
    };
  }
};
</script>

<style scoped>
p {
}
</style>