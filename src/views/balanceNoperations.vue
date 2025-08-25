<script setup>
import balance from '@/components/balance.vue';
import settinghead from '@/components/settinghead.vue';
import actions from '@/components/actions.vue';
</script>

<template>
    <v-container>

        <v-row>
            <v-col>
                <settinghead />
            </v-col>
        </v-row>
        <v-row class="text-center my-5">
            <v-col>
                <h3>Balance & Operations</h3>
            </v-col>
        </v-row>

        <v-row class="float-center">
            <v-col>
                <balance />
            </v-col>
        </v-row>

        <v-row class="mx-1">
            <actions />
        </v-row>
    </v-container>
</template>