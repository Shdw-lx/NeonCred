<script setup>
import { useRoute } from 'vue-router'
import { computed } from 'vue'

const route = useRoute()

const showActions = computed(() => {
  return route.path !== '/dashboard'
})
</script>

<template>
  <v-container fluid>
    <v-row>
      <v-col cols="6">
        <v-card
          rounded="xl"
          class="pa-2"
          link
          to="/send"
          style="background: rgba(102, 63, 181, 0.28)"
        >
          <v-row>
            <v-col class="text-center">
              <v-icon style="rotate: 320deg" class="text-h4">mdi-send</v-icon>
            </v-col>
          </v-row>
          <v-row>
            <v-col class="text-center">
              <span class="text-h5">Send</span>
            </v-col>
          </v-row>
        </v-card>
      </v-col>

      <v-col>
        <v-card
          rounded="xl"
          class="pa-2"
          link
          to="/receive"
          style="background: rgba(0, 0, 0, 0.36)"
        >
          <v-row>
            <v-col class="text-center">
              <v-icon class="text-h4">mdi-cash-fast</v-icon>
            </v-col>
          </v-row>

          <v-row>
            <v-col class="text-center">
              <span class="text-h5">Receive</span>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>

    <v-row v-if="showActions">
      <v-col>
        <v-card
          rounded="xl"
          class="pa-2"
          link
          to="withdraw"
          style="background: rgba(0, 0, 0, 0.36)"
        >
          <v-row>
            <v-col class="text-center">
              <v-icon class="text-h4">mdi-cash</v-icon>
            </v-col>
          </v-row>

          <v-row>
            <v-col class="text-center">
              <span class="text-h5">Withdraw</span>
            </v-col>
          </v-row>
        </v-card>
      </v-col>

      <v-col>
        <v-card
          rounded="xl"
          class="pa-2"
          link
          to="/purchase"
          style="background: rgba(102, 63, 181, 0.28)"
        >
          <v-row>
            <v-col class="text-center">
              <v-icon class="text-h4">mdi-cart</v-icon>
            </v-col>
          </v-row>

          <v-row>
            <v-col class="text-center">
                <span class="text-h5">Buy</span>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
