<script setup>
import { useRouter } from 'vue-router';
import { ref, watch } from 'vue'

const router = useRouter()

const steps = [
    {
        title: 'Enter your personnal informations', 

        formField: [
            {
                label: 'Name',
                model: 'firstName',
                type: 'text'
            },
            {
               label: 'Surname',
               model: 'lastName',
               type: 'text' 
            }
        ],

        option: 'Register with',
        optBtn: 'Google',
        link: 'I already have an account'
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
                type: 'password'
            }
        ]
    },

    {
        title: 'Choose your account type',

        formField: [
            {
                label: 'Confirm your password',
                model: 'Cpassword',
                type: 'password'
            },
            {
                label: 'Account type',
                model: 'AccType',
                type: 'select'
            }
        ]
    }
]

const currentStep = ref(0)
const formData = ref({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    Cpassword: '',
    AccType: ''
})

function nextStep() {
    if (currentStep.value < steps.length -1) {
        currentStep.value++
    } else {
        console.log('Form submitted:', formData.value)
        router.push('/dashboard')
    }
}
</script>

<template>
    
</template>