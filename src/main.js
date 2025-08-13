import { createApp } from 'vue'
import App from './App.vue'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import 'vuetify/styles'

import './assets/style.css'
import { createVuetify } from 'vuetify'
import router from './router'

const vuetify = createVuetify({
    components,
    directives,

})


createApp(App).use(router).use(vuetify).mount('#app')
