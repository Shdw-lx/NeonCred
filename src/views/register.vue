<script setup>
import { useRouter } from 'vue-router'
import { ref, watch } from 'vue'

const router = useRouter()

const steps = [
  {
    title: 'Enter your personnal informations',

    formField: [
      {
        label: 'Name',
        model: 'firstName',
        type: 'text',
      },
      {
        label: 'Surname',
        model: 'lastName',
        type: 'text',
      },
    ],

    btn: 'Continue',

    option: 'Register with',
    optBtn: 'Google',
    link: 'I already have an account',
  },

  {
    title: 'Enter your account ids',

    formField: [
      {
        label: 'E-mail',
        model: 'eMail',
        type: 'email',
      },
      {
        label: 'Password',
        model: 'password',
        type: 'password',
      },
    ],

    btn: 'Continue',
  },

  {
    title: 'Choose your account type',

    formField: [
      {
        label: 'Confirm your password',
        model: 'Cpassword',
        type: 'password',
      },
      {
        label: 'Account type',
        model: 'AccType',
        type: 'select',
      },
    ],

    btn: 'Link Start !', //SAO reference you knoooooow
  },
]

const currentStep = ref(0)
const formData = ref({
  firstName: '',
  lastName: '',
  email: '',
  password: '',
  Cpassword: '',
  AccType: '',
})

function nextStep() {
  if (currentStep.value < steps.length - 1) {
    currentStep.value++
  } else {
    console.log('Form submitted:', formData.value)
    router.push('/dashboard')
  }
}
</script>

<template>
  <v-container>
    <v-row class="my-6">
      <v-col>
        <h1 class="text-center">Welcome in new player</h1>
      </v-col>
    </v-row>

    <v-row class="">
      <v-col>
        <v-sheet
          class="text-center rounded-xl"
          style="
            background: linear-gradient(rgba(102, 63, 181, 1), rgba(0, 0, 0, 1));
          "
          width="384"
          height="492"
        >
          <v-form :key="currentStep">
            <v-row class="mx-5">
              <v-col>
                <h3 class="text-center mt-9 mb-6">{{ steps[currentStep].title }}</h3>
              </v-col>
            </v-row>

            <v-row dense class="mx-3 my-10">
              <v-col v-for="field in steps[currentStep].formField" :key="field.model" cols="12">
                <v-text-field
                  v-if="field.type !== 'select'"
                  :label="field.label"
                  v-model="formData[field.model]"
                  :type="field.type"
                  outlined
                ></v-text-field>

                <v-select
                  v-else
                  :label="field.label"
                  :items="[]"
                  v-model="formData[field.model]"
                  outlined
                ></v-select>
              </v-col>
            </v-row>

            <v-row class="mb-10" :class="currentStep === steps.length - 1 ? 'justify-center' : ''">
              <v-col :class="currentStep === steps.length - 1 ? 'text-center' : 'text-end me-10'">
                <v-btn variant="tonal" style="transform: translateY(10%)" @click="nextStep">{{
                  steps[currentStep].btn
                }}</v-btn>
              </v-col>
            </v-row>
          </v-form>
        </v-sheet>
      </v-col>
    </v-row>

    <div class="text-center mt-10">
      <v-row v-if="steps[currentStep].option">
        <v-col class="text-center">
          <span>{{ steps[currentStep].option }}</span>
        </v-col>
      </v-row>

      <v-row v-if="steps[currentStep].optBtn">
        <v-col>
          <v-btn variant="tonal" style="background: rgba(102, 63, 181, 0.28);"
            ><h5>{{ steps[currentStep].optBtn }}</h5></v-btn
          >
        </v-col>
      </v-row>

      <v-row v-if="steps[currentStep].link">
        <v-col class="text-center">
          <router-link to="/login">{{ steps[currentStep].link }}</router-link>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>
