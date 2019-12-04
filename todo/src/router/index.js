import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue' // 경로 설정을 원하는 컴포넌트를 import 한다.

Vue.use(VueRouter) // vue에게 VueRouter 를 사용하라고 알려줌

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
