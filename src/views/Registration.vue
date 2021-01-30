<template>
  <v-form v-model="valid">
  <h1> Register</h1>
    <v-container>
      <form id="registerForm">
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
            <v-text-field
              type="name"
              label="Name"
              id="name"
              v-model="name"
              name="name"
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
            <v-text-field
              type="surname"
              id="surname"
              v-model="surname"
              label="Surname"
              name="surname"
              required
            ></v-text-field>
          </v-col>
        </v-row>
        <v-flex class="button text-xs-center" mt-5>
          <v-btn  v-on:click.prevent="post" :disabled="!canAdd" type="submit">Register</v-btn>
        </v-flex>
      </form>
      <div class="status">{{status}}</div>  
    </v-container>
  </v-form>
</template>

<script>

const apiUrl = "http://25.93.216.221:8080";
let apiEndPoint = apiUrl + "/register";

export default {
    name: 'App',

  data() {
    return {
      email: '',
      name: '',
      surname: '',
      password: '',
      status: '',
    }
  },
    computed: {
      canAdd() {
          return this.email.trim().length >= 3 && this.password.trim().length >=3;
      }
  },


  // methods: {
  //   post: function(){
  //       let formData = new FormData(document.getElementById("registerForm"));
  //       this.$http.post(apiEndPoint, formData)
  //       .then(response => {
  //           console.log(response.data);
  //           this.status = response.data;
  //       }, response => {this.status = response.data;});
  //   }
  // },


  methods: {
    async post() {
      let formData = new FormData(document.getElementById("registerForm"));
      let response = await this.axios.post(apiEndPoint, formData);
      console.log("Sukces", response);
      this.status = response.data;
    },
  }

  // methods: {
  //   post() {
  //     let formData = new FormData(document.getElementById("registerForm"));
  //     this.axios.post(apiEndPoint, formData)
  //     .then(response => {
  //       console.log("Sukces", response);
  //       this.status = response.data;
  //     })
  //     .catch(err => console.log('err', err));
  //   }
  // }
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
