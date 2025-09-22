<script setup>
</script>

<template>
  <v-container>
    <v-row>
      <v-col>
        <v-sheet rounded="lg" class="my-10" style="background: rgba(217, 217, 217, 0.06)">
          <v-form>
            <v-row>
              <v-col>
                <v-text-field
                  class="mx-2 mt-10"
                  label="Amout"
                  placeholder="Min: 250"
                  v-model="amount"
                  outlined
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col>
                <v-text-field
                  class="mx-2 my-2"
                  label="Note(Optional)"
                  v-model="reason"
                  outlined
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row class="text-center mx-0">
              <v-col class="text-center">
                <v-btn color="deep-purple-darken-1" prepend-icon="mdi-identifier">
                  User ID
                </v-btn>
              </v-col>

              <v-col class="text-center">
                <v-btn color="grey-darken-1" prepend-icon="mdi-camera"
                  >QR Code</v-btn
                >
              </v-col>
            </v-row>
          </v-form>
        </v-sheet>
      </v-col>
    </v-row>

    <v-row class="mt-10">
      <v-col class="text-center">
        <v-btn prepend-icon="mdi-check" color="indigo-accent-4">Valider</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
