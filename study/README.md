# Vue 공식 튜토리얼 연습

각 폴더는 Vue 공식 가이드의 큰 제목에 해당합니다.
폴더에는 연습한 예제파일과 가이드의 내용을 참고해 README 파일에 정리되어 있습니다.(사실상 가이드와 대부분 유사합니다.)
가이드의 내용을 실제 예제코드를 짜서 경험해보는 것을 목표로 합니다.

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

# 참고

https://kr.vuejs.org/v2/guide/
