# Vuex

## Vuex 설치
### yarn
```
yarn add vuex
```
### npm
```
npm install vuex --save
```

## Promise 설치
Vuex는 Promise를 사용
IE 처럼 지원대상 브라우저가 아직 Promise를 지원하지 않는다면 라이브러리를 사용해
```
npm install es6-promise --save # NPM
yarn add es6-promise # Yarn
```
사용시 아래 코드를 추가하면 적용 가능하다.
```
import 'es6-promise/auto'
```
## Vuex를 왜 쓰지?
- Vue.js는 부모 - 자식 컴포넌트간에 props(데이터전달), emit(이벤트전달)으로 통신한다.
- 컴포넌트가 중첩되어 있거나 부모 - 자식간이 아닌 컴포넌트간에 데이터 통신이 어렵다.
- Vuex.js는 데이터를 vuex의 store에 모아 꺼내씀으로써 상태관리를 편하게 한다.

## store.js
- vue인스턴스의 모든 데이터를 모아두는 저장소
- state : data 관리
- getter : computed 속성 관리(캐싱)
- mutation : 동기함수 관리(methods)
- actions : 비동기함수 관리(methods)

## 참고
https://vuex.vuejs.org/kr/guide/mutations.html
https://joshua1988.github.io/web-development/vuejs/vuex-start/#%EB%93%A4%EC%96%B4%EA%B0%80%EB%A9%B0
https://github.com/sbomhoo/vuex-test/blob/master/README.md