<script setup></script>

<template>
  <v-container>
    <v-row>
      <v-col>
        <v-card
          prepend-icon="mdi-account-circle"
          width="170"
          height="49"
          class="mx-auto float-start"
          title="User#000"
          color="transparent"
          append-icon="mdi-chevron-right"
          rounded="lg"
          to="/user"
        ></v-card>
      </v-col>

      <v-col class="text-end">
        <v-btn variant="text" icon="mdi-magnify"></v-btn>
        <v-btn variant="text" to="/notifications" icon="mdi-bell-outline"></v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
