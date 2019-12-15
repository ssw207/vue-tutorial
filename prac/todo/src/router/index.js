import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoFrame from '../views/TodoFrame.vue' // 경로 설정을 원하는 컴포넌트를 import 한다.

Vue.use(VueRouter) // vue에게 VueRouter 를 사용하라고 알려줌

const routes = [
  {
    path: '/todo',
    name: 'todo',
    component: TodoFrame
  },
  {
    path: '/user/login',
    name: 'login',
    component: () => import('../component/user/Login.vue')
  },
  {
    path: '/user/users',
    name: 'users',
    component: () => import('../component/user/Users.vue')
  },
  {
    path: '/user/userCreate',
    name: 'userCreate',
    component: () => import('../component/user/UserCreate.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
