<script setup>
import starterheader from '../components/starterheader.vue'
</script>

<template> 
    <v-container>
        <v-row>
            <v-col>
                <starterheader />
            </v-col>
        </v-row>

        <v-row justify="center">
            <v-col>
               <v-img :width="400" aspect-ratio="1/1" class="mt-10 pt-10"  cover src="public/Nyoncoin.jpg"></v-img> 
            </v-col>
        </v-row>

        <v-row justify="center">
            <v-col class="text-center">
                <v-btn to="/starter" variant="tonal" color="text-white" style="background-color: rgba(102, 63, 181, 0.28) ;">Enter</v-btn>
            </v-col>
        </v-row>
    </v-container>
</template>