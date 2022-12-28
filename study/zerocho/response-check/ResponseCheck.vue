<template>
  <div>
    <!--v-bind 설정시 date의 state 데이터를 값으로 쓸수 있다 : 로 축약가능-->
    <div id="screen" :class="state" @click="onClickScreen">{{ message }}</div>
    <template v-show="result.length"> <!--랜더링은 되지만 display none상태. template은 실제 없는 태그로 랜더링됨-->
      <div>평균 시간 : {{averate}}ms</div>
      <button @click="onReset">리셋</button>
    </template>
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
  computed: { // 데이터를 가공할때 사용한다. 데이터가 캐싱되어 계산외에 다른 메시지가 바뀌어서 랜더링이 다시되더라도 재계산되지 않으므로 성능이 좋다
    averate() {
      return this.result.reduce((a, b) => a + b, 0) / this.result.length || 0;
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