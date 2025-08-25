<script setup>
import settinglist from '@/components/settinglist.vue';
import settinghead from '@/components/settinghead.vue';
</script>

<template>
    <v-container>
        <v-row>
            <v-col>
                <settinghead />
            </v-col>
        </v-row>

        <v-row class="my-5">
            <v-col class="text-center">
                <h3>Profile & Settings</h3>
            </v-col>
        </v-row>

        <v-row>
            <v-col>
                <settinglist />
            </v-col>
        </v-row>
    </v-container>
</template>