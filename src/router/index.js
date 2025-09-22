import { createRouter, createWebHistory } from 'vue-router'
import landing from '@/views/landing.vue'
import starter from '@/views/starter.vue'
import register from '@/views/register.vue'
import login from '@/views/login.vue'
import dashboard from '@/views/dashboard.vue'
import user from '@/views/user.vue'
import balanceNoperations from '@/views/balanceNoperations.vue'
import notifications from '@/views/notifications.vue'
import send from '@/views/send.vue'
import purchase from '@/views/purchase.vue'
import history from '@/views/history.vue'
import userdata from '@/views/userdata.vue'
import password from '@/views/password.vue'


const routes = [
  { path: '/', component: landing },
  { path: '/starter', component: starter },
  { path: '/register', component: register },
  { path: '/login', component: login },
  { path: '/dashboard', component: dashboard },
  { path: '/user', component: user },
  { path: '/balanceandoperations', component: balanceNoperations },
  { path: '/notifications', component: notifications },
  { path: '/send', component: send },
  { path: '/purchase', component: purchase },
  { path: '/history', component: history },
  { path: '/userdata', component: userdata },
  { path: '/password', component: password },

]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
