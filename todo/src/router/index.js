import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoFrame from '../views/TodoFrame.vue' // 경로 설정을 원하는 컴포넌트를 import 한다.

Vue.use(VueRouter) // vue에게 VueRouter 를 사용하라고 알려줌

const routes = [
  {
    path: '/TodoFrame',
    name: 'TodoFrame',
    component: TodoFrame
  },
  {
    path: '/Home',
    name: 'Home',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
