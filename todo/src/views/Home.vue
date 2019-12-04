<template>
  <div class="hello">
    오늘 해야 할 일
    <ul v-if="toDoItems.length">
      <li v-for="toDoItem of toDoItems" :key="toDoItem.id">
        {{ toDoItem.title }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios"; // 아까 받은 axios 패키지를 사용하기 위해 import한다

export default {
  name: "hello",
  data: function() {
    return {
      toDoItems: [] // toDoItems를 빈 리스트로 초기화한다.
    };
  },
  created() {
    // 초기화 함수를 정의 한다.
    axios
      .get("http://127.0.0.1:8081/api/todo/list") // http://localhost:8081/api/list/에 get call을 한다.
      .then(res => {
        this.toDoItems = res.data; // 반환되는 값을 toDoItems에 저장한다.
        // this.test = res;
      })
      .catch();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
h1,
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
}
</style>
