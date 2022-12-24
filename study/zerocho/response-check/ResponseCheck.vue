<template>
  <div>
<!--    v-model 설정시 date의 state 데이터를 값으로 쓸수 있다-->
    <div id ="screen" v-bind:class="state">{{message}}</div>
    <div>
      <div>평균 시간 : {{time}}</div>
      <button @click="onReset">리셋</button>
    </div>
  </div>
</template>

<script>


export default {
  data() {
    return {
      message: '눌려주세요',
      state: 'waiting',
      time: 0,
    }
  },
  methods: {
    onReset() {
      this.message = '';
      this.time = 0;
    },
  },
}
</script>

<style scoped>
  #screen {
    width: 150px;
    height: 150px;
    border: 1px solid black;
    text-align: center;
    line-height: 150px;
    font-size: 30px;
  }
  #screen.waiting {
    background: aqua;
  }
  #screen.ready {
    background: red;
  }
  #screen.now {
    background: greenyellow;
  }
</style>