Vue.component ('myform', { 
  props: ['title'],
  template: '<li>{{ title }}<button v-on:click="remove">삭제</button></li>'
});

new Vue({
  el:'#app8',
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


Vue.component('todo-item', {
  template: '\
    <li>\
      {{ title }}\
      <button v-on:click="$emit(\'remove\')">Remove</button>\
    </li>\
  ',
  props: ['title']
})

new Vue({
  el: '#app8',
  data: {
    newTodoText: '',
    todos: [
      {
        id: 1,
        title: 'Do the dishes',
      },
      {
        id: 2,
        title: 'Take out the trash',
      },
      {
        id: 3,
        title: 'Mow the lawn'
      }
    ],
    nextTodoId: 4
  },
  methods: {
    addNewTodo: function () {
      this.todos.push({
        id: this.nextTodoId++,
        title: this.newTodoText
      })
      this.newTodoText = ''
    }
  }
})