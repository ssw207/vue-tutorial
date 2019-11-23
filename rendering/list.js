Vue.component ('myform', { 
  props: ['title'],
  template: '<li>{{ title }}<button v-on:click="remove">삭제</button></li>'
});

new Vue({
  el:'#app1',
  data: {
    newTodoText :'',
    newTodoId : 4,
    list : [
      {title:'a',id:1},
      {title:'b',id:2},
      {title:'c',id:3},
    ]
  },
  methods: {
    remove : function() {

    }
  }
});