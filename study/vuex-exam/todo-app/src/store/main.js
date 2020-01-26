import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

let idTask =0;
let idlabel =0;

let tasks =[
  {id:0,name:'첫번째',done:false},
  {id:1,name:'두번째',done:false},
  {id:2,name:'세번째',done:false},
];

let labels =[
  {id:0,name:'레이블1',done:false},
  {id:1,name:'레이블2',done:false},
  {id:2,name:'레이블3',done:false},
];

export default new Vuex.Store({
  state: {
    tasks,
    labels
  },
  getters: {
    filteredTask() {
      
    }
  },
  mutations: {
    addTask() {

    },
    addLabel() {

    }
  },
  /* actions: {
  },
  modules: {
  } */
})

