<script setup></script>

<template>
  <v-container>
    <v-bottom-navigation grow mode="shift" color="deep-purple" bg-color="transparent" class="mb-3 mx-0">
      <v-btn rounded="xl" to="/dashboard">
        <v-icon>mdi-home</v-icon>

        <span class="text-center">Home</span>
      </v-btn>

      <v-btn rounded="xl" to="/balanceandoperations">
        <v-icon>mdi-account-cash</v-icon>

        <span class="text-center">Balance & Operations</span>
      </v-btn>

      <v-btn rounded="xl" to="/history">
        <v-icon>mdi-history</v-icon>

        <span class="text-center">Operations Journal</span>
      </v-btn>
    </v-bottom-navigation>
  </v-container>
</template>
