<script setup>
import dashheader from '@/components/dashheader.vue';
import balance from '@/components/balance.vue';
import actions from '@/components/actions.vue';
import quick from '@/components/quick.vue';
</script>

<template>
    <v-container>
        <v-row>
            <v-col>
                <dashheader />
            </v-col>
        </v-row>

        <v-row>
            <v-col>
                <balance />
            </v-col>
        </v-row>

        <v-row class="mt-0">
            <v-col>
                <actions />
            </v-col>
        </v-row>

        <v-row class="mt-0">
            <v-col>
                <quick />
            </v-col>
        </v-row>

        <v-row>
            <v-col>
                <!--Recent transactions-->
            </v-col>
        </v-row>


    </v-container>
</template>