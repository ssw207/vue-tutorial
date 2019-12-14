<template>
  <input :value="value" v-on="listeners" />
</template>

<script>
export default {
  props: {
    defaultText: String,
    value: String
  },
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: event => {
          this.$emit("input", event.target.value);
        }
      };
    }
  }
};
</script>

<style></style>
