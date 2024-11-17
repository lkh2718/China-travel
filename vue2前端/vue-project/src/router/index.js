import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
  {
    path: '/fuel',
    name: 'fuel',
    component: () => import( '../views/element/FuelManagement.vue')
  },
  {
    path: '/stuff',
    name: 'stuff',
    component: () => import( '../views/element/StuffManagement.vue')
  },

  {
    path: '/',
    name:'login',
    component: () => import('../views/login/LoginUser.vue'),
  },
  {
    path: '/login',
    name:'login',
    component: () => import('../views/login/LoginUser.vue'),
  },
  {
     path: '/register',
    name:'register',
    component: () => import('../views/register/RegisterUser.vue'),
  },
   {
    path: '/dashboard',
    name:'dashboard',
    component: () => import('../views/dashboard/DashBoard1.vue'),

  } 
]

const router = new VueRouter({
  routes
})

export default router
