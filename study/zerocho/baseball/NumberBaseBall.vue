<template>
  <div>
    <h1>{{ random }}</h1>
    <form @submit.prevent="onSubmitForm"><!-- method의 onSubmitForm 함수가 submit이벤트가 발생하면 실행된다-->
      <!-- input의 값은 data - values값 과 양방향 연동된다. answer 이름으로 이 태그에 vue에서 접근할수 있다 -->
      <input ref="answer" minlength="4" maxlength="4" v-model="value"/>
      <button type="submit">입력!</button>
    </form>
    <div>시도 {{ tries.length }}</div>
    <ul>
      <li v-for="t in tries">
        <div>{{t.try}}</div>
        <div>{{t.result}}</div>
      </li>
    </ul>
  </div>
</template>

<script>

const getRandomNumber = () => {
  const candidate = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  const array = [];
  for (let i = 0; i < 4; i++) {
    const chosen = candidate.splice(Math.floor(Math.random() * (9 - i)), 1)[0];
    array.push(chosen);
  }
  return array;
};

export default {

  data() {

    return {
      random: getRandomNumber(),
      tries: [],
      value: '',
    };
  },
  methods: {
    onSubmitForm(e) {
      //e.preventDefault(); // form 의 기본 이벤트를 방지한다. 화면을 새로고침하는 기본 이벤트를 막는다. @submit.prevent 와동일함

      if (this.value === this.random.join('')) {
        this.push('일치');
      } else {
        this.push('불일치');
      }

      this.reset();
    },
    reset() {
      this.value = '';
      this.result = '';
    },
    push(result) {
      this.tries.push({
        try: this.value,
        result: result,
      });
      this.$refs.answer.focus(); // input에 포커스를 맞춘다.
    }
  },
}
</script>

<style scoped>

</style>