<script setup>
import { useRoute } from 'vue-router'
import { computed } from 'vue'
import navbar from './components/navbar.vue'

const route = useRoute()

const backgroundClass = computed(() => {
  switch (route.path) {
    case '/':
      return 'landing-background'
    case '/starter':
      return 'landing-background'
    case '/register':
      return 'login-background'
    case '/login':
      return 'login-background'
    case '/dashboard':
      return 'dashboard-background'
    case '/user':
      return 'dashboard-background'
    case '/balanceandoperations':
      return 'dashboard-background'
    case '/notifications':
      return 'dashboard-background'
    case '/send':
      return 'dashboard-background'
    case '/purchase':
      return 'dashboard-background'
    case '/history':
      return 'dashboard-background'
    case '/userdata' :
      return 'dashboard-background'
    case '/password':
      return 'login-background'
    default:
      return ''
  }
})

const showNNavbar = computed(() => {
  return route.path !== '/' 
  && route.path !== '/starter' 
  && route.path !== '/register' 
  && route.path !== '/login' 
  && route.path !== '/password'
})
</script>

<template> 
  <v-app>
    <v-main :class="backgroundClass">
      <router-view />
      <navbar v-if="showNNavbar" />
    </v-main>
  </v-app>
</template>

<style scoped></style>
