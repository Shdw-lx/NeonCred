<script setup>
import sending from '@/components/sending.vue';
</script>

<template>
    <v-container>
        <v-row>
            <v-col class="mb-5">
                <v-btn color="transparent" icon="mdi-chevron-left" variant="flat"></v-btn>
            </v-col>
        </v-row>

        <v-row class="mt-10 mb-10">
            <v-col class="text-center">
                <h3>Neons Transfer</h3>
            </v-col>
        </v-row>

        <v-row class="mt-10">
            <v-col>
                <sending />
            </v-col>
        </v-row>
    </v-container>
</template>