# 목적

## SPA 구축

## axios로 Spring Boot Api 서버 연동

## cors 이슈해결

- 원인 : 도메인이 다른 주소로 리소스를 요청할때 발생 ex) localhost:1000 -> localhost:2000
- 해결 : API서버의 응답헤더를 변경해서 해결. CORS를 허용해주는 도메인을 설정하는 Access-Control-Allow-Origin 프로퍼티를 변경해서 해결
- backend : boot설정을 통해 해결
- frontend : webpack proxy 설정 ex) package.json -> "proxy" : "http://localhost:8080"

## bootstrap 적용

https://bootstrap-vue.js.org/docs/

```
npm install vue bootstrap-vue bootstrap
```

vue에서 bootstrap을 사용할수 있도록 main.js에 아래 코드 입력

```
/* bootstrap */
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue);
```

# 패키지 구조

router
component
