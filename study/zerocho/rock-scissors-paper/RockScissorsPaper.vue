<template>
  <div id="computer" :style="computedStyleObject"></div>
  <div>
    <button @click="onClickButton('바위')">바위</button>
    <button @click="onClickButton('가위')">가위</button>
    <button @click="onClickButton('보')">보</button>
  </div>
  <div>{{ result }}</div>
  <div>현재 {{ score }}정</div>
</template>

<script>

const rspCodes = {
  바위: '0',
  가위: '-142px',
  보: '-284px',
};

const score = {
  가위: 1,
  바위: 0,
  보: -1,
}

const computerChoice = (imgCoord) => {
  return Object.entries(rspCodes).find(function (v) {
    return v[1] === imgCoord;
  })[0];
};

let interval = null;

export default {

  data() {
    return {
      result: '',
      score: 0,
      imageCode: '0',
    };
  },
  computed: { // 데이터를 가공할때 사용한다. 데이터가 캐싱되어 계산외에 다른 메시지가 바뀌어서 랜더링이 다시되더라도 재계산되지 않으므로 성능이 좋다
    computedStyleObject() {
      return {
        background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${this.imageCode} 0`,
      };
    },
  },
  methods: {
    onClickButton(choice) {
      clearInterval(interval); // 잠깐 손음멈춘다

      const myScore = score[choice];
      const computerScore = score[computerChoice(this.imageCode)];
      const diff = myScore - computerScore;

      if (diff === 0) {
        this.result = '비겼습니다.';
      } else if ([-1, 2].includes(diff)) {
        this.result = '이겼습니다.';
        this.score++;
      } else {
        this.result = '졌습니다.';
        this.score--;
      }

      setTimeout(() => {
        this.changeHand();
      }, 1000);
    },
    changeHand() {
      interval = setInterval(() => { // 컴포넌트가 사라져도 계속실행됨
        if (this.imageCode === rspCodes.바위) {
          this.imageCode = rspCodes.가위;
        } else if (this.imageCode === rspCodes.가위) {
          this.imageCode = rspCodes.보;
        } else {
          this.imageCode = rspCodes.바위;
        }
      }, 100);
    }
  },
  created() { // 처음 컴포넌트가 보여질때 (보여지지만 화면에 안나타남), 데이터가 완성된 상태. 자바스크립트 상태로만 있다
    console.log('created');
  },
  mounted() { // 화면에 나타난후, 보통화면 조작 관련 작업은 여기서 한다
    console.log('mounted');
    this.changeHand();
  },
  updated() { // 화면에 데이터가 변경되서 화면이 다시 그려질때
    console.log('updated');
  },
  beforeDestroy() { // 컴포넌트가 사라지기 직전
    console.log('beforeDestroy');
    clearInterval(interval); // 컴포넌트가 사라지면 setInterval도 사라져야함
  },
  destroyed() { // false로 바뀌면서 화면이 사라질때
    console.log('destroyed');
  },
}
</script>

<style scoped>
#computer {
  width: 142px;
  height: 200px;
}

</style>