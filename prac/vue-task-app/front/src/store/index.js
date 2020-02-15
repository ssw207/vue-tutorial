import Vue from "vue";
import Vuex from "vuex";
import actions from "./actions";
import mutations from "./mutations";

Vue.use(Vuex);

const state = {
  auth: {
    userId,
    userName
  },
  board: {
    listTasks: []
  },
  dragging: {
    target: null, // 드래그앤드롭 대상 태스크 id
    from: null, // 원래 속했던 태스크 목록id
    to: null // 드롭된 테스크 목록id
  }
};

export default new Vuex.Store({
  state,
  mutations,
  actions
});
