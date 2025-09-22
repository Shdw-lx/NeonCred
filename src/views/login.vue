<script setup></script>

<template>
  <v-container>
    <v-row class="my-10">
      <v-col>
        <h1 class="text-center">Welcome Back !</h1>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-sheet
          class="text-center rounded-xl mb-2"
          style="
            background: linear-gradient(
              200deg,
              rgba(85, 44, 112, 0.87) 17%,
              rgba(0, 0, 0, 1) 100%,
              rgba(164, 33, 151, 0.87) 100%
            );
          "
          width="384"
          height="492"
        >
          <v-form>
            <v-row>
              <v-col>
                <h2 class="text-center mt-2">Login</h2>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field
                  class="mt-10 mx-2"
                  label="Username / E-mail"
                  v-model="credential"
                  outlined
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col>
                <v-text-field
                  class="mt-2 mx-2"
                  label="Password"
                  v-model="password"
                  outlined
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col>
                <v-btn variant="tonal" class="mt-3">Login</v-btn>
              </v-col>
            </v-row>

            <v-row class="mt-5">
                <v-col>
                    <router-link to="/password">Forgot Password ?</router-link>
                </v-col>
            </v-row>
          </v-form>
        </v-sheet>
      </v-col>
    </v-row>

    <div class="text-center mt-3">
      <v-row>
        <v-col>
          <span>Login with</span>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <v-btn variant="tonal" style="background: rgba(102, 63, 181, 0.28);"><h5>Google</h5></v-btn>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <router-link to="/register">No account ? Register</router-link>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>
