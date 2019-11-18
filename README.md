# Veu.js 튜토리얼

# 설치

### CDN

```
<!-- 개발버전, 도움되는 콘솔 경고를 포함. -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- 상용버전, 속도와 용량이 최적화됨. -->
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
```

### NPM

```
npm install vue @vue/cli @vue/cli-service-global
npm install bower install vue
```

- vue create 로 생성
- @vue/cli-service-global : create-react-app 와 유사한 템플릿
- serve, build, inspect 스크립트 명령어 사용가능

### 웹팩

```
module.exports = {
  // ...
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js' // 'vue/dist/vue.common.js'  webpack 1용 입니다
    }
  }
}
```

### Browserify(?) - package.json

```
{
  // ...
  "browser": {
    "vue": "vue/dist/vue.common.js"
  }
}
```

### Rollup(?) - package.json

```
const alias = require('rollup-plugin-alias')

rollup({
  // ...
  plugins: [
    alias({
      'vue': require.resolve('vue/dist/vue.esm.js')
    })
  ]
})
```

### Parcel - package.json

```
{
  // ...
  "alias": {
    "vue" : "./node_modules/vue/dist/vue.common.js"
  }
}
```

## 선언적 데이터 랜더링

JS 데이터와 DOM을 연결해 JS데이터가 변경되면 DOM에 변경내용이 자동으로 랜더링 된다.

### 문자열 바인딩

```
<div id="app">
  {{ message }}
</div>
```

```
var app = new Vue({
  el: '#app',
  data: {
    message: '안녕하세요 Vue!'
  }
})
```

데이터와 DOM이 연결되어 javascript app.messgae 값에 따라 html의 {{ message }} 데이터가 업데이트된다.

### 엘리멘트 속성 바인딩

```
<div id="app-2">
  <span v-bind:title="message">
    내 위에 잠시 마우스를 올리면 동적으로 바인딩 된 title을 볼 수 있습니다!
  </span>
</div>
```

```
var app2 = new Vue({
  el: '#app-2',
  data: {
    message: '이 페이지는 ' + new Date() + ' 에 로드 되었습니다'
  }
})
```

#### 디렉티브

- vue에서 제공하는 특수속성
- v-접두어가 붙어 있다.
- 랜더링된 DOM에 특수한 반응형 동작을한다.
- `v-bind:title` : title 속성을 vue인스턴스의 message속성으로 최신상태를 유지
  => `app2.message = '새로운 메시지` 로 변경시 html이 업데이트 된다.

## 조건문, 반복문

```
<div id="app-3">
  <p v-if="seen">이제 나를 볼 수 있어요</p>
</div>
```

```
var app3 = new Vue({
  el: '#app-3',
  data: {
    seen: true
  }
})
```

`app3.seen = false` 입력시 메시지가 사라진다. DOM구조에도 데이터를 바인딩 할 수 있음.
vue 엘리먼트가 vue 에 삽입/업데이트/제거될때 자동으로 젼환효과를 적용 할 수 있다.

## v-for

배열의 데이터를 바인딩해 목록을 표시

```
<div id="app-4">
  <ol>
    <li v-for="todo in todos">
      {{ todo.text }}
    </li>
  </ol>
</div>
```

```
var app4 = new Vue({
  el: '#app-4',
  data: {
    todos: [
      { text: 'JavaScript 배우기' },
      { text: 'Vue 배우기' },
      { text: '무언가 멋진 것을 만들기' }
    ]
  }
})
```

`app4.todos.push({ text: 'New item' })` 입력시 DOM에 데이터가 추가된다.

## v-on

vue 인스턴스에서 매소드를 호출하는 이벤트 리스너를 추가 할 수 있다.

```
<div id="app-5">
  <p>{{ message }}</p>
  <button v-on:click="reverseMessage">메시지 뒤집기</button>
</div>
```

```
var app5 = new Vue({
  el: '#app-5',
  data: {
    message: '안녕하세요! Vue.js!'
  },
  methods: {
    reverseMessage: function () {
      this.message = this.message.split('').reverse().join('')
    }
  }
})
```

## v-model

데이터 출력과 DOM객체에 값을 동시에 세팅(양방향 바인딩?)

```
<div id="app-6">
  <p>{{ message }}</p>
  <input v-model="message">
</div>
```

```
var app6 = new Vue({
  el: '#app-6',
  data: {
    message: '안녕하세요 Vue!'
  }
})
```

## 컴포넌트 작성방법

### 등록

DOM을 건드리지 않고 앱의 상태만을 업데이트

```
<div id="app-7">
  <ol>
    <!--
      이제 각 todo-item 에 todo 객체를 제공합니다.
      화면에 나오므로, 각 항목의 컨텐츠는 동적으로 바뀔 수 있습니다.
      또한 각 구성 요소에 "키"를 제공해야합니다 (나중에 설명 됨).
     -->
    <todo-item
      v-for="item in groceryList"
      v-bind:todo="item"
      v-bind:key="item.id"
    ></todo-item>
  </ol>
</div>
```

```
Vue.component('todo-item', { // 'todo-item' 컴포넌트를 만듬
  props: ['todo'], // 'v-bind:todo' 항목으로 데이터 바인딩
  template: '<li>{{ todo.text }}</li>' // 바인딩된 데이터를 이용해서 동적으로 DOM을 그린다
})

var app7 = new Vue({
  el: '#app-7', // id="app-7" 인 DOM을 타겟
  data: {
    groceryList: [ // list의 객체가 item으로 각각 전달됨
      { id: 0, text: 'Vegetables' },
      { id: 1, text: 'Cheese' },
      { id: 2, text: 'Whatever else humans are supposed to eat' }
    ]
  }
})
```

```

```

# vscode extension

vue 파일 사용 : Vue Components

# 참조

가이드 : https://kr.vuejs.org/v2/guide/
vscode 익스텐션 : https://vuejs.kr/jekyll/update/2017/02/21/vscode-vue-development-settings/
