<template>
  <v-form v-model="valid">
  <h1>Log In</h1>
    <v-container>
      <form id="loginForm" >
        <v-row class="d-flex justify-content-center">
          <v-col cols="12" md="4">
            <v-text-field
              type="email"
              label="E-mail"
              id="email"
              v-model="email"
              name="email"
              autofocus
              required
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field
              type="password"
              id="password"
              v-model="password"
              label="Password"
              name="password"
              required
            ></v-text-field>
          </v-col>
        </v-row>
        <v-flex class="button text-xs-center" mt-5>
          <v-btn :disabled="!canAdd" v-on:click.prevent="login" type="submit">Log In</v-btn>
        </v-flex>
      </form>
      <div class="status">{{status}}</div>  
    </v-container>

  </v-form>
</template>


<script>


const apiUrl = "http://25.93.216.221:8080";


export default {
    name: 'App',

  data() {
    return {
      email: '',
      password: '',
      status: "",
      status2: ""
    }
  },
  computed: {
    canAdd() {
        return this.email.trim().length >= 3 && this.password.trim().length >=3;
    }
  },
  // methods: {
  //   async post() {
  //     let formData = new FormData(document.getElementById("loginForm"));
  //     let response = await this.axios.post(apiEndPoint, formData)
  //     console.log("Sukces", response);
  //     this.status = response.data;
  //   },
  // }
    methods: {
      login() { 
        let apiEndPoint = apiUrl + "/signIn";       
        let formData = new FormData(document.getElementById("loginForm"));
        this.axios.post(apiEndPoint, formData)
        .then(response => {
          console.log("Sukces", response);
          this.status = response.data;
          // window.location.reload();
          window.location.replace("/");
          
        })
        .catch(err => {
          console.log('Error: ', err);
          this.status = "Bład logowania";
          });
      },   

  }
}
</script>

<style scoped lang="less">
  h1 {
    margin-top: 20px;
  }
  .status {
    margin-top: 40px;
    font-weight: 600;
    font-size: 32px;

  &:first-letter {      
      text-transform: uppercase;
    }
  }
</style>
