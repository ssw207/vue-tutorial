<template>
  <div>
    <BaseInput
      placeholder="defaultText"
      v-model="inputText"
      v-on:keydown.enter="add"
    ></BaseInput>
    <ul v-if="todos.length">
      <ListItem
        v-for="todo of todos"
        :todo="todo"
        :key="todo.id"
        v-on:remove="remove"
      ></ListItem>
    </ul>
  </div>
</template>

<script>
import ListItem from "./ListItem.vue";
import BaseInput from "./BaseInput.vue";

let idx = 1;
export default {
  components: {
    ListItem,
    BaseInput
  },
  data() {
    return {
      inputText: "",
      todos: [
        { id: idx++, text: "data1" },
        { id: idx++, text: "data2" },
        { id: idx++, text: "data3" }
      ]
    };
  },
  methods: {
    add: function() {
      var s = this.inputText.trim();
      this.todos.push({ id: idx++, text: s });
    },
    remove: function(removeId) {
      this.todos = this.todos.filter(function(v) {
        return v.id !== removeId;
      });
    }
  }
};
</script>

<style></style>
