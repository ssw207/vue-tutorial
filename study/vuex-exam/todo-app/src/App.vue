<template>
  <div id="app">
    <TodoFrame/>
  </div>
</template>

<script>
import TodoFrame from './components/TodoFrame.vue'

export default {
  name: 'app',
  components: {
    TodoFrame
  }
}
</script>

<style>