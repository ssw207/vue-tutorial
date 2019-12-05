<template>
  <div class="hello">
    <b-card
      header="오늘 해야 할 일"
      style="max-width: 40rem; margin: auto; margin-top: 10vh;"
      class="mb-2"
      border-variant="info"
      align="left"
    >
      <b-form-group id="to-do-input">
        <b-container fluid>
          <BaseInput
            type="text"
            placeholder="새 할 일을 적으세요."
            @add="addTodo"
          ></BaseInput>
        </b-container>
      </b-form-group>

      <b-list-group v-if="todoItems.length">
        <TodoItem
          v-for="todo of todoItems"
          :key="todo.id"
          :todo="todo"
          @delete="deleteTodo"
        ></TodoItem>
      </b-list-group>
    </b-card>
  </div>
</template>

<script>
import TodoItem from "./TodoItem.vue";
import BaseInput from "./BaseInput.vue";
import axios from "axios"; // 아까 받은 axios 패키지를 사용하기 위해 import한다

export default {
  components: {
    TodoItem,
    BaseInput
  },
  data: function() {
    return {
      todoItems: [] // todoItems를 빈 리스트로 초기화한다.
    };
  },
  methods: {
    listTodo: function() {
      const url = "http://127.0.0.1:8081/api/todo/list";

      axios.get(url).then(res => {
        if (res.status !== 200) return;

        this.todoItems = res.data;
      });
    },
    addTodo: function(inputText) {
      const url = "http://127.0.0.1:8081/api/todo/save";
      const data = { title: inputText.trim(), done: true };

      axios.post(url, data).then(res => {
        if (!res.data) return;

        this.todoItems.push(res.data);
      });
    },
    deleteTodo: function(todoId) {
      const url = "http://127.0.0.1:8081/api/todo/" + todoId;
      const data = { id: todoId };

      axios.delete(url, data).then(res => {
        if (res.status !== 200) return;

        this.todoItems = this.todoItems.filter(todo => {
          return todo.id !== todoId;
        });
      });
    }
  },
  created() {
    // 초기화 함수를 정의 한다.
    this.listTodo();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
/* h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #35495e;
} */
</style>
