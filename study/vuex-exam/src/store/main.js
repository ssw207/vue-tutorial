import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    count: 0
  },
  mutations: {
    inc(state, payload) {
      state.count += payload.count;
    },
    dec(state, payload) {
      state.count -= payload.count;
    }
  }
});

export default store;
