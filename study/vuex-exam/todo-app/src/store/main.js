import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
//초기 state
let tasks =[
  {id:0,name:'우유 사기',done:false,idLabels:[0]},
  {id:1,name:'빵 사기',done:false,idLabels:[1]},
  {id:2,name:'전공책 사기',done:false,idLabels:[2]},
];

let labels =[
  {id:0,name:'쇼핑'},
  {id:1,name:'교통'},
  {id:2,name:'식비'}
];

// 스토어 정의
export default new Vuex.Store({
  state: {
    tasks,
    labels,
    filter:null, // 필터링 적용할 레이블 id
    idTask:3,
    idLabel:3
  },
  getters: {
    // 필터링된 테스크
    filteredTasks(state) {
      const filter = state.filter;
      if( filter == null || filter === '') {
        return state.tasks;
      }
      return state.tasks.filter( task => task.idLabels.includes(filter));
    }
  },
  mutations: {
    // 테스크 추가
    addTask(state, { name,  labels}) {
      state.tasks.push({id:state.idTask, name, done:false, idLabels:labels});
      state.idTask++;
    },
    // 레이블 추가
    addLabel(state, { name }) {
      state.labels.push({id:state.idLabel, name, done:false});
      state.idLabel++;
    },
    // 필터 변경
    changeFilter(state, { filter }) {
      state.filter = filter;
    },
    // 할일 실행여부
    toggleTaskStatus(state, { id }) {
      state.tasks = state.tasks.map(task => {
        if (task.id === id) {
          task.done = !task.done;
        }
        return task;
      });
    },
    // 로컬스토리지에 저장한 정보 복구
    restore (state, payload) {
      state.tasks = payload.tasks;
      state.labels = payload.labels;
      state.nextTaskId = payload.idTask;
      state.nextLabelId = payload.idLabel;
      state.filter = payload.filter;
    }
  },
  actions: {
    // 로컬스토리지에 현재 상태정보 저장
    save({state}) {
      const data = {...state};
      localStorage.setItem('todo-app-data', JSON.stringify(data));
    },
    // 상태정보 복구
    restore({commit}) {
      const data = localStorage.getItem('todo-app-data');
      if (data) {
        commit('restore', JSON.parse(data));
      }
    }
  }
})

