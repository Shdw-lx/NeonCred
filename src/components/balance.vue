<script setup>
const neon = 'src/assets/Nyoncoin.jpg'

const card = {
  title: 'Total Balance',
  amount: '45.000,25',
  currency: neon,
  income: '2.500',
  outcome: '8.500',
}
</script>

<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <v-card
          class="mx-auto pa-4"
          rounded="xl"
          elevation="8"
          style="background: rgba(217, 217, 217, 0.06)"
          link
          to="/balanceandoperations"
        >
          <h4>{{ card.title }}</h4>
          <div class="d-flex align-center">
            <span class="mr-2 text-h3">{{ card.amount }}</span>
            <v-img :src="card.currency" max-width="50" max-height="50" contain></v-img>
          </div>

          <v-row class="mt-5" style="background: rgba(217, 217, 217, 0.06)">
            <v-col cols="6">
              <h5 class="text-start">Income</h5>
              <div class="d-flex float-start align-center">
                <span class="text-h6 mr-1">{{ card.income }}</span>
                <v-img :src="card.currency" width="30" height="30" contain></v-img>
              </div>
            </v-col>

            <v-col cols="6" class="text-end">
              <h5>Outcome</h5>
              <div class="d-flex float-end align-center">
                <span class="text-h6 mr-1">{{ card.outcome }}</span>
                <v-img :src="card.currency" width="30" height="30" contain></v-img>
              </div>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
