# Vue-Router 사용법

## Vue-Router 설치
CDN
```
https://unpkg.com/vue-router/dist/vue-router.js
```

NPM
```
npm install vue-router
```

설치한 vue-router모듈을 vue가 사용 할 수 있도록 `Vue.use(VueRouter)` 입력
```
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
```

## 시작하기
### HTML
```
<div id="app">
  <h1>Hello App!</h1>
  <p>
    <!-- 네비게이션을 위해 router-link 컴포넌트를 사용합니다. -->
    <!-- 구체적인 속성은 `to` prop을 이용합니다. -->
    <!-- 기본적으로 `<router-link>`는 `<a>` 태그로 렌더링됩니다.-->
    <router-link to="/foo">Go to Foo</router-link>
    <router-link to="/bar">Go to Bar</router-link>
  </p>
  <!-- 라우트 아울렛 -->
  <!-- 현재 라우트에 맞는 컴포넌트가 렌더링됩니다. -->
  <router-view></router-view>
</div>
```
`<router-link>` 태그를 클릭시 `to` 속성에 정의된 컴포넌트가 `<router-view></router-view>` 태그에 랜더링된다.


### JS
1. 모듈시스템 사용시 `Vue.use(VueRouter)`로 Vue가 VueRouter를 사용할수 있도록 한다.
1. 라우터에 연결할 컴포넌트를 정의한다.
1. `{ path: '경로', component: 정의된 컴포넌트 객체 }`로 라우터를 정의한다.
1. `const router= new VueRouter({routes : 위에서 생성한 라우터 객체})` 로 VueRouter 인스턴스를 생성한다.
1. vue 인스턴스 생성시 위에서 생성한 라우터 인스턴스를 옵션으로 전달한다. `new Vue({router:router})`
1. 생선한 vue인스턴스를 id가 app인 DOM에 마운트한다. `new Vue({...}).$mount('#app')`

```
// 0. 모듈 시스템 (예: vue-cli)을 이용하고 있다면, Vue와 Vue 라우터를 import 하세요
// 그리고 `Vue.use(VueRouter)`를 호출하세요


// 1. 라우트 컴포넌트를 정의하세요.
// 아래 내용들은 다른 파일로부터 가져올 수 있습니다.
const Foo = { template: '<div>foo</div>' }
const Bar = { template: '<div>bar</div>' }

// 2. 라우트를 정의하세요.
// Each route should map to a component. The "component" can
// 각 라우트는 반드시 컴포넌트와 매핑되어야 합니다.
// "component"는 `Vue.extend()`를 통해 만들어진
// 실제 컴포넌트 생성자이거나 컴포넌트 옵션 객체입니다.
const routes = [
  { path: '/foo', component: Foo },
  { path: '/bar', component: Bar }
]

// 3. `routes` 옵션과 함께 router 인스턴스를 만드세요.
// 추가 옵션을 여기서 전달해야합니다.
// 지금은 간단하게 유지하겠습니다.
const router = new VueRouter({
  routes // `routes: routes`의 줄임
})

// 4. 루트 인스턴스를 만들고 mount 하세요.
// router와 router 옵션을 전체 앱에 주입합니다.
const app = new Vue({
  router
}).$mount('#app')

// 이제 앱이 시작됩니다!
```

## 동적 라우팅
특정 패턴의 동적 라우트를 동일한 컴포넌트에 연결하는 경우 
라우트를 :로 설정시 동일한 컴포넌트로 매핑된다. ex)/user/:id 
```
const User = {
  template: '<div>User</div>'
}

const router = new VueRouter({
  routes: [
    // 동적 세그먼트는 콜론으로 시작합니다.
    { path: '/user/:id', component: User }
  ]
})
```

컴포넌트에 전달된 id는  `$route.params.id` 로 받을수 있다.
url의 쿼리스트링은 `$route.query` 형태로 받는다.
```
const User = {
  template: '<div>User {{ $route.params.id }}</div>'
}
```

### 동적 라우팅으로 페이지 변경시 params
/user/foo -> /user/bar 이동시 동적 라우팅으로 이동했다면 
컴포넌트를 재사용하므로 라이프 사이클 훅이 작동하지 않는다.
변경되는 params에 반응하려면
```
const User = {
  template: '...',
  watch: {
    '$route' (to, from) {
      // 경로 변경에 반응하여...
    }
  }
}
```
```
const User = {
  template: '...',
  beforeRouteUpdate (to, from, next) {
    // react to route changes...
    // don't forget to call next()
  }
}
```
이렇게 사용

### 매칭 우선순위
여러 라우트가 일치할경우 라우트 정의가 먼저된 순서에 따라 결정된다.

## 프로그램방식 네비게이션
router인스턴스의 push 함수를 이용하면 프로그램적으로 라우터를 호출할 수 있다.
router.push(name: 라우트이름, params: {파라밑터명 : 값});
```
// 리터럴 string
router.push('home')

// object
router.push({ path: 'home' })

// 이름을 가지는 라우트
router.push({ name: 'user', params: { userId: 123 }})

// 쿼리와 함께 사용, 결과는 /register?plan=private 입니다.
router.push({ path: 'register', query: { plan: 'private' }})
```

히스토리 이동
```
// 한 단계 앞으로 갑니다. history.forward()와 같습니다. history.forward()와 같습니다.
router.go(1)

// 한 단계 뒤로 갑니다. history.back()와 같습니다.
router.go(-1)

// 3 단계 앞으로 갑니다.
router.go(3)

// 지정한 만큼의 기록이 없으면 자동으로 실패 합니다.
router.go(-100)
router.go(100)
```

## 이름을 가지는 뷰
```
<router-view class="view one"></router-view>
<router-view class="view two" name="a"></router-view>
<router-view class="view three" name="b"></router-view>
```
```
const router = new VueRouter({
  routes: [
    {
      path: '/',
      components: {
        default: Foo,
        a: Bar,
        b: Baz
      }
    }
  ]
})
```
## 리다이렉트
https://router.vuejs.org/kr/guide/essentials/redirect-and-alias.html

# 라우트 컴포넌트 속성전달
https://router.vuejs.org/kr/guide/essentials/passing-props.html

# 히스토리모드
https://router.vuejs.org/kr/guide/essentials/history-mode.html#%EC%84%9C%EB%B2%84-%EC%84%A4%EC%A0%95-%EC%98%88%EC%A0%9C

## 훅함수
### 전역훅
### 라우트단위훅
### 컴포넌트내 훅

# 참고
1.vue-router 공식문서
https://router.vuejs.org/kr/guide/#html

2.