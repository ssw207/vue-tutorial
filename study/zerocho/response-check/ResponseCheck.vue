<template>
  <div>
    <!--v-bind 설정시 date의 state 데이터를 값으로 쓸수 있다 : 로 축약가능-->
    <div id="screen" :class="state" @click="onClickScreen">{{ message }}</div>
    <div>
      <div>평균 시간 : {{result.reduce((a, b) => a + b, 0) / result.length || 0}}ms</div>
      <button @click="onReset">리셋</button>
    </div>
  </div>
</template>

<script>

let startTime = 0;
let endTime = 0;
let timeOut = null;

export default {
  data() {
    return {
      message: '눌려주세요',
      state: 'waiting',
      result: [],
    }
  },
  methods: {
    onReset() {
      this.message = '눌러주세요';
      this.result = [];
      this.state = 'waiting';
    },
    onClickScreen() {

      let state = this.state;
      // console.log('시작', state);

      if (state == 'waiting') {
        this.message = '초록색이 되면 클릭하세요';
        this.state = 'ready';
        timeOut = setTimeout(() => {
          this.state = 'now';
          this.message = '지금 클릭';
          startTime = new Date();
        }, Math.floor(Math.random() * 1000) + 2000); // 2-3초
      } else if (state == 'ready') {
        clearTimeout(timeOut);
        this.message = '너무 성급하시네요 초록색이 된수에 변경해쥇요';
        this.state = 'ready';
      } else if (state == 'now') {
        endTime = new Date();
        this.message = '준비';
        this.state = 'waiting';
        this.result.push(endTime - startTime);
      }
    }
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