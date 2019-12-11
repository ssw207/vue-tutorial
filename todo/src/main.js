/* Default */
import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

/* element-ui */
import Element from 'element-ui'
import './element-variables.scss'
import locale from 'element-ui/lib/locale/lang/ko'

Vue.use(Element, { locale })


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
