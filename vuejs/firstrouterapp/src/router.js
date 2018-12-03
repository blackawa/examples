import Vue from 'vue'
import VueRouter from 'vue-router'
import Todos from './components/Todos'
import NewTodo from './components/NewTodo'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    { path: '/', component: Todos },
    { path: '/new', component: NewTodo },
  ]
})
