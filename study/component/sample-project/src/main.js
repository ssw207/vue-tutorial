import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App), // App.vue를 랜더링
}).$mount('#app') // /public/index.html 의 DOM에 마운트
