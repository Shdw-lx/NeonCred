<script setup>
import { useRoute } from 'vue-router';
import { computed } from 'vue'

const route = useRoute()

const backgroundClass = computed(() => {
    switch (route.path) {
        case '/' :
            return 'landing-background'
        case '/starter' :
            return 'landing-background'
        case '/register' :
            return 'login-background'
        case '/login' :
            return 'login-background'
        default:
            return ''
    }
})
</script>

<template>
 <v-app>
    <v-main :class="backgroundClass">
        <router-view />
    </v-main>
 </v-app>
</template>

<style scoped>

</style>
