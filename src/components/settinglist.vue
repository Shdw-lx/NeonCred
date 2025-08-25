<script setup></script>

<template>
  <v-container fluid>
    <v-col class="mx-5 mt-5">
      <v-row>
        <v-card
          width="320"
          height="70"
          rounded="lg"
          class="my-4"
          style="background: rgba(217, 217, 217, 0.06)"
          prepend-icon="mdi-account-circle"
          title="Personnal informations"
          subtitle="View and edit your personnal informations."
        ></v-card>
      </v-row>

      <v-row>
        <v-card
          width="320"
          height="70"
          rounded="lg"
          class="my-4"
          style="background: rgba(217, 217, 217, 0.06)"
          prepend-icon="mdi-lock"
          title="Security"
          subtitle="Modify your security parameters."
        ></v-card>
      </v-row>

      <v-row>
        <v-card
          width="320"
          height="70"
          rounded="lg"
          class="my-4"
          style="background: rgba(217, 217, 217, 0.06)"
          prepend-icon="mdi-heart"
          title="Preferences"
          subtitle="Personnalize the app to your liking."
        ></v-card>
      </v-row>

      <v-row>
        <v-card
          width="320"
          height="70"
          rounded="lg"
          class="my-4"
          style="background: rgba(217, 217, 217, 0.06)"
          prepend-icon="mdi-mail"
          title="Feedback"
          subtitle="send a feedbacks and suggestions to the developpers !"
        ></v-card>
      </v-row>
    </v-col>
  </v-container>
</template>
