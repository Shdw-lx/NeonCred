<script setup>
import starterheader from '../components/starterheader.vue';
import { ref, watch } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const steps = [
    {
        subtitle: 'Your campus - Your credits - Your rules !',
        content: 'In this neon gris, every point count.\n Convert your cash into digital credits and blaze through your student life with style - no coins, no queues, no stress.',
        button: 'Continue'
    },

    {
        subtitle: 'Recharge. Transfer. Pay.\n All in one place',
        content: 'Whether you\'re grabbing food at the canteen, printing your next course or paying back a friend, you\'re always one tap away from a smooth, instant transaction.',
        button: 'Continue'
    },

    {
        subtitle: 'Fast. Secure. Always online.',
        content: 'Ready to level up your wallet ?\n Jack in ! Let\'s play !',
        button: 'Getting started'
    }
]

const currentStep = ref(0)
const decryptedSubtitle = ref('')
const decryptedContent = ref('')
const decryptedButton = ref('')

function scrambleText(target, setter, speed = 20) {
    let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*'
    let iterations = 0
    let interval = setInterval(() => {
        setter(
            target.split('').map((char, i) => {
                if (char === '\n') return '\n'
                if (i < iterations) return target[i]
                return chars[Math.floor(Math.random() * chars.length)]
            })
            .join('')
        )

        iterations += 1 / 2
        if (iterations >= target.length) {
            setter(target)
            clearInterval(interval)
        }
    }, speed)
}

function decryptStep(step) {
    scrambleText(step.subtitle, (v) => (decryptedSubtitle.value = v), 15)
    scrambleText(step.content, (v) => (decryptedContent.value = v), 10)
    scrambleText(step.button, (v) => (decryptedButton.value = v), 25)
}

watch(currentStep, (newStep) => {
    decryptStep(steps[newStep])
})

decryptStep(steps[currentStep.value])

function nextStep() {
    if (currentStep.value < steps.length - 1) {
        currentStep.value++
    } else {
        router.push('/register')
    }
}

</script>

<template>
    <v-container style="height: 100vh; overflow: hidden;">
        <div class="scanlines"></div>
        <v-row>
            <v-col>
                <starterheader />
            </v-col>
        </v-row>

        <Transition name="cyber-glitch" mode="out-in">
            <v-row>
                <v-row :key="currentStep" class="justify-center mt-10 pt-10 text-center mx-6">
                    <v-col>
                        <h4 class="subtitle">{{ decryptedSubtitle }}</h4>
                    </v-col>
                </v-row>

                <v-row :key="currentStep" class="mt-10 pt-10">
                    <v-col>
                        <v-card class="rounded-xl mx-6" height="326" width="352" style="background: radial-gradient(rgba(115, 115, 115, 0) 0%, rgba(217, 217, 217, 0.2) 100%);">
                            <p class="text-center my-10 py-5 px-5">{{ decryptedContent }}</p>
                        <v-card-actions class="justify-center mt-10 pt-10">
                            <v-btn variant="tonal" class="neon-btn" @click="nextStep" style="background: rgba(102, 63, 181, 0.50);">{{ decryptedButton }}</v-btn>
                        </v-card-actions>
                    </v-card>
                    </v-col>
                </v-row>
            </v-row>
        </Transition>
    </v-container>
</template>

<style scoped>

.scanlines {
    position: absolute;
    top: 0; left: 0;
    width: 100%; height: 100%;
    pointer-events: none;
    background: repeating-linear-gradient(
        to bottom,
        rgba(255, 255, 255, 0.05),
        rgba(255, 255, 255, 0.05) 1px,
        transparent 2px,
        transparent 4px
    );
    animation: flicker 3s infinite;
    z-index: 1;
}
@keyframes flicker {
    0%, 19%, 21%, 23%, 25%, 54%, 56%, 100% { opacity: 0.9; }
    20%, 24%, 55% { opacity: 0.3; }
}

.cyber-glitch-enter-active, .cyber-glitch-leave-active {
    animation: glitch 0.5s ease forwards;
}
@keyframes glitch {
  0% { transform: translate(0); opacity: 0; text-shadow: 2px 0 red, -2px 0 cyan; }
  20% { transform: translate(-2px, 2px); opacity: 1; text-shadow: 2px 0 red, -2px 0 cyan; }
  40% { transform: translate(2px, -2px); text-shadow: -2px 0 red, 2px 0 cyan; }
  60% { transform: translate(-1px, 1px); text-shadow: 1px 0 red, -1px 0 cyan; }
  80% { transform: translate(1px, -1px); text-shadow: -1px 0 red, 1px 0 cyan; }
  100% { transform: translate(0); opacity: 1; text-shadow: 0 0 5px #0ff, 0 0 10px #f0f; }
}
</style>