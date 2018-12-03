import Vue from 'vue'
import VueRouter from 'vue-router'
import SignIn from '../components/SignIn'
import SignUp from '../components/SignUp'

Vue.use(VueRouter)

const routes = [
  {path: '/sign-in', component: SignIn},
  {path: '/sign-up', component: SignUp},
]

export default new VueRouter({
  routes
})