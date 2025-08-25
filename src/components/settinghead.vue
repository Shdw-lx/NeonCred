<script setup>
import { useRoute } from 'vue-router';
import { computed } from 'vue';

const route = useRoute()

const icon = computed(() => {
    switch (route.path) {
        case '/user':
            return 'mdi-magnify'

        case '/notifications':
            return 'mdi-filter-outline'
    }
})

</script>

<template>
  <v-container fluid>
    <v-col>
      <v-row>
        <v-col cols="6">
          <v-row>
            <v-btn color="transparent" class="float-start" variant="flat">
              <v-icon class="text-h5">mdi-arrow-left</v-icon>
            </v-btn>
          </v-row>
        </v-col>

        <v-col>
            <v-row class="float-end">
                <v-btn color="transparent" variant="flat">
                    <v-icon class="text-h5">{{ icon }}</v-icon>
                </v-btn>
            </v-row>
        </v-col>
      </v-row>
    </v-col>
  </v-container>
</template>
