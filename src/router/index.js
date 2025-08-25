import { createRouter, createWebHistory } from 'vue-router'
import landing from '@/views/landing.vue'
import starter from '@/views/starter.vue'
import register from '@/views/register.vue'
import login from '@/views/login.vue'
import dashboard from '@/views/dashboard.vue'
import user from '@/views/user.vue'
import balanceNoperations from '@/views/balanceNoperations.vue'
import notifications from '@/views/notifications.vue'


const routes = [
  { path: '/', component: landing },
  { path: '/starter', component: starter },
  { path: '/register', component: register },
  { path: '/login', component: login },
  { path: '/dashboard', component: dashboard },
  { path: '/user', component: user },
  { path: '/balanceandoperations', component: balanceNoperations },
  { path: '/notifications', component: notifications },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
