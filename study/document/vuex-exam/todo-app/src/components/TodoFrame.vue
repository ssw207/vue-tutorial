<template>
  <div>
    <div>
      <h1>현재리스트 저장</h1>
      <div>
        <button @click="save">저장</button>
        <button @click="restore">복구</button>
      </div>
    </div>
    <div>
      <h1>테스크 리스트</h1>
      <ul v-if="tasks.length > 0">
        <li 
          v-for="task of tasks"
          :key="task.id"
        >
          <span>{{task.name}} / </span>
          <span 
            v-for="id of task.idLabels"
            :key="id"
          > 
            {{getLabelText(id)}}
          </span>
          <input type="checkbox" :checked="task.done" @change="toggleTaskStatus(task.id)">
        </li>
      </ul>
      <li v-else>task가 없습니다</li>
    </div>

    <div>
      <h1>테스크 추가</h1>
      <ul v-if="labels.length > 0">
        <li
          v-for="label of labels"
          :key="label.id"
        >
        <input type="checkbox" :value="label.id" v-model="checkedLabels"/><label>{{label.name}}</label>
        </li>
      </ul>
      <form @submit.prevent="addTask">
        <input type="text" v-model="newTaskName"><button type="submit">추가</button>
      </form>
    </div>

    <div>
      <h1>레이블 추가</h1>
      <form @submit.prevent="addLabel">
        <input type="text" v-model="newLabelName"><button type="submit">추가</button>
      </form>
    </div>
    
    <div>
      <h1>레이블 필터링</h1>
      <ul v-if="labels.length > 0">
        <li>
          <label><input type="radio" :checked="null === filter" @change="changeFilter(null)"/>전체</label>
        </li>
        <li
          v-for="label of labels"
          :key="label.id"
        >
        <input type="radio" :checked="label.id === filter" @change="changeFilter(label.id)"/>{{label.name}}
        </li>
      </ul>
      <li v-else>레이블 이 없습니다</li>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newTaskName : '',
      newLabelName : '',
      checkedLabels:[]
    }
  },
  computed: {
    tasks() {
      return this.$store.getters.filteredTasks;
    },
    labels() {
      return this.$store.state.labels;
    },
    filter () {
      return this.$store.state.filter
    }
  },
  methods: {
    addTask() {
      this.$store.commit('addTask', {name : this.newTaskName, labels:this.checkedLabels});
      this.newTaskName = '',
      this.checkedLabels = [];
    },
    addLabel() {
      this.$store.commit('addLabel', {name : this.newLabelName});
      this.newLabelName = '';
    },
    changeFilter(idLabel) {
      this.$store.commit('changeFilter', { filter:idLabel });
    },
    toggleTaskStatus(id) {
      this.$store.commit('toggleTaskStatus', { id });
    },
    save() {
      this.$store.dispatch('save');
    },
    restore() {
      this.$store.dispatch('restore');
    },
    // 레이블 ID로 레이블명 받아오기
    getLabelText (id) {
      const labels = this.labels;
      const label = labels.find(label => label.id === id);
      return label.name ? label.name : '';
    },
  }
};
</script>

<style>
</style>