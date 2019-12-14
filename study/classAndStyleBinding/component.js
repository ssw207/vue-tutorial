Vue.component('my-component', {
  template: '<p class="foo bar">hi</p>'
})

//new Vue할때 컴포넌트가 랜더링된다. new하지 않으면 선언된 컴포넌트는 html로 출력됨
var app = new Vue({
  el : '#app1',
  data : {
    isActive : true
  }
})