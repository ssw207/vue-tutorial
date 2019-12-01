# Vue 인스턴스

```
var vm = new Vue({
  // 옵션
})
```

옵션객체에서 데이터, 템플릿, 마운트할 엘리먼트, 메소드, 콜백옵션등 정의

## 컴포넌트 트리

```
Root Instance
└─ TodoList
   ├─ TodoItem
   │  ├─ DeleteTodoButton
   │  └─ EditTodoButton
   └─ TodoListFooter
      ├─ ClearTodosButton
      └─ TodoListStatistics
```

## 속성, 메소드

```
// 데이터 객체
var data = { a: 1 }

// Vue인스턴스에 데이터 객체를 추가합니다.
var vm = new Vue({
  data: data
})

// 같은 객체를 참조합니다!
vm.a === data.a // => true

// 속성 설정은 원본 데이터에도 영향을 미칩니다.
vm.a = 2
data.a // => 2

// ... 당연하게도
data.a = 3
vm.a // => 3
```

`data`객체를 프록시로 처리
객체의 값이 변하면 Vue인스턴스에 객체의 값도 변한다.(역도 성랍)
데이터가 변경되면 화면은 다시 랜덩링됨 => 'data' 인스턴스가 생성될때 존재한 값들만 반응

```
var obj = {
  foo: 'bar'
}

Object.freeze(obj)

new Vue({
  el: '#app',
  data: obj
})
```

```
<div id="app">
  <p>{{ foo }}</p>
  <!-- obj.foo는 더이상 변하지 않습니다! -->
  <button v-on:click="foo = 'baz'">Change it</button>
</div>
```

`Object.freeze(obj)` 사용시 속성이 변경되지 않음
다만 `obj.foo = "test";` `vm.foo = "test";` 이런방식으로는 변경됨.

### 인스턴스 관련 속성, 메소드

```
var data = { a: 1 }
var vm = new Vue({
  el: '#example',
  data: data
})

vm.$data === data // => true
vm.$el === document.getElementById('example') // => true

// $watch 는 인스턴스 메소드 입니다.
vm.$watch('a', function (newVal, oldVal) {
  // `vm.a`가 변경되면 호출 됩니다.
})
```

## 인스턴스 라이프 사이클 훅

vue 인스턴스는 생성될때 초기화가 됩니다. 예를들어

1. 템플릿을 컴파일하는경우 => ?
1. 인스턴스를 Dom에 마운트 하는경우 => var app = new Vue({...})
1. 데이터가 변경되어 DOM 을 업데이트 하는 경우 => app.msg = 'test';

위와같은 경우에 사용자 정의 로직을 실행할수 있는 **라이프 사이클 훅** 도 호출됩니다.

```
new Vue({
  data: {
    a: 1
  },
  created: function () {
    // `this` 는 vm 인스턴스를 가리킵니다.
    console.log('a is: ' + this.a)
  }
})
// => "a is: 1"
```

예를 들어 `createed` 훅은 인스턴스가 생성된 후에 호출됩니다.
대표적으로 `mounted , updated, destroyed` 가 있습니다.

옵션이나 콜백에 `() =>` 화살표 함수 사용은 권장 되지 않습니다.
ex)
`created: () => console.log(this.a)`
`vm.$watch('a', newValue => this.myMethod())`

화살표 함수들은 부모 컨텍스트에 바인딩 되기 때문에 오류가 발생합니다.
ex)
`Uncaught TypeError: Cannot read property of undefined`
`Uncaught TypeError: this.myMethod is not a function`

## 라이프 사이클

![lifecycle](./img/lifecycle.png)

### 1.Createion 컴포넌트 초기화

라이프사이클 단계에서 가장먼저 실행. 컴포넌트가 DOM(화면)에 추가되기전에 실행(서버랜더링에서도 지원된다.)

- 서버단, 클라이언트단 랜더링에서 모두 처리해야할 일이 있을때 사용.
- DOM에 추가되기 전 이기 때문에 DOM에 접근하거나 `this.$el` 을 사용할수 없다
  (`this.$el` 사용시 DOM객체가 리턴됨)

#### beforeCreate

가장 먼저 실행되는 훅. data와 events가 세팅되지 않은 시점

이벤트 https://vuejs.org/v2/api/#vm-on 참조

vm.\$on

```
vm.$on('test', function (msg) {
  console.log(msg)
})
vm.$emit('test', 'hi')
// => "hi"
```

`vm.$emit`으로 실행되는 현재 vm의 커스텀 이벤트를 듣는다. 이벤트를 트리거하는 매서드의 args가전달된다.

```
vm.$once
```

```
vm.$off

```

```
vm.$emit

```

# v

scode extension

# 참조

가이드
https://kr.vuejs.org/v2/guide/instance.html

라이프사이클
https://medium.com/witinweb/vue-js-%EB%9D%BC%EC%9D%B4%ED%94%84%EC%82%AC%EC%9D%B4%ED%81%B4-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-7780cdd97dd4

```

```
