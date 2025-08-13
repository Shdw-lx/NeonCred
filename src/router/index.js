import { createRouter, createWebHistory } from "vue-router";

import landing from '../views/landing.vue'
import starter from "../views/starter.vue";
import register from "../views/register.vue";

const routes = [
    { path: '/', component: landing},
    { path: '/starter', component: starter},
    { path: '/register', component: register},
]

const router = createRouter({
    history:createWebHistory(),
    routes
})

export default router