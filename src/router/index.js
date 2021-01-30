import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/productlist',
    name: 'productlist',

    component: () => import(
      '../views/ProductList.vue'
     )
  },
  {
    path: '/login',
    name: 'login',

    component: () => import(
      '../views/Login.vue'
     )
  },
  {
    path: '/registration',
    name: 'registration',

    component: () => import(
      '../views/Registration.vue'
     )
  },
  {
    path: '/productmanager',
    name: 'productmanager',

    component: () => import(
      '../views/ProductManager.vue'
     )
  },
  {
    path: '/mytutorials',
    name: 'mytutorials',

    component: () => import(
      '../views/MyTutorials.vue'
     )
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
