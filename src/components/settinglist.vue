<script setup></script>

<template>
  <v-container fluid>
    <v-row>
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
            link to="/userdata"
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
            link to="/security"
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
            link to="/preferences"
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
            link to="/feedback"
          ></v-card>
        </v-row>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="mx-2">
        <v-card
          width="320"
          height="60"
          rounded="lg"
          class="my-4"
          style="background: rgba(217, 217, 217, 0.06);"
          prepend-icon="mdi-logout"
          title="Logging out"
          color="red"

          link to="/login"
        ></v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
