<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>오늘 해야 할 일</span>
      </div>
      <el-table :data="todoItems" style="width: 100%">
        <el-table-column prop="title" label="Title" width="180">
        </el-table-column>
        <el-table-column prop="done" label="Done"> </el-table-column>
      </el-table>
    </el-card>

    <!-- <b-card
      header="오늘 해야 할 일"
      style="max-width: 40rem; margin: auto; margin-top: 10vh;"
      class="mb-2"
      border-variant="info"
      align="left"
    >
      <b-form-group id="to-do-input">
        <b-container fluid>
          <BaseInput
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
          @check="checkTodo"
        ></TodoItem>
      </b-list-group>
    </b-card> -->
  </div>
</template>

<script>
// import TodoItem from "./TodoItem.vue";
// import BaseInput from "./BaseInput.vue";
import axios from "axios"; // 아까 받은 axios 패키지를 사용하기 위해 import한다

let baseUrl = "http://127.0.0.1:8081/api/todo";
export default {
  components: {
    // TodoItem,
    // BaseInput
  },
  mounted() {
    // 초기화 함수를 정의 한다.
    this.listTodo();
  },
  data: function() {
    return {
      todoItems: [], // todoItems를 빈 리스트로 초기화한다.
      reqData: {}
    };
  },
  methods: {
    listTodo: function() {
      const url = `${baseUrl}/list`;

      axios.get(url).then(res => {
        if (res.status !== 200) return;

        this.todoItems = res.data;
      });
    },
    addTodo: function(inputText) {
      if (!inputText) return;
      const url = `${baseUrl}/save`;
      const data = { title: inputText.trim(), done: false };

      axios.post(url, data).then(res => {
        if (!res.data) return;

        this.todoItems.push(res.data);
      });
    },
    deleteTodo: function(todoId) {
      const url = `${baseUrl}/${todoId}`;
      const data = { id: todoId };

      axios.delete(url, data).then(res => {
        if (res.status !== 200) return;

        this.todoItems = this.todoItems.filter(todo => {
          return todo.id !== todoId;
        });
      });
    },
    checkTodo: function(data) {
      const url = `${baseUrl}/update`;
      // const data = { id: todo.id, done: todo.done };
      axios.put(url, data).then(res => {
        if (res.status !== 200) return;
      });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  width: 480px;
}
</style>
