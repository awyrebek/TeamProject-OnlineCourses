<template>
  <div id="app">
    <div id="nav" class="d-flex flex-wrap ">
      <router-link class="mr-4" to="/"><v-btn elevation="2">Home</v-btn></router-link>
      <router-link class="mr-4" to="/productlist"><v-btn elevation="2">Product List</v-btn></router-link>
      <router-link v-show="!loggedIn" class="mr-4" to="/login"><v-btn elevation="2">Login</v-btn></router-link>
      <router-link v-show="!loggedIn" class="mr-4" to="/registration"><v-btn elevation="2">Registration</v-btn></router-link>
      <router-link v-show="loggedIn" class="mr-4" to="/productmanager"><v-btn elevation="2">ProductManager</v-btn></router-link>
      <router-link v-show="loggedIn" class="mr-4" to="/mytutorials"><v-btn elevation="2">My Tutorials</v-btn></router-link>
      <v-btn v-show="loggedIn" v-on:click="logout()">Wyloguj</v-btn>
    </div>      
    <router-view/>   
  </div> 
</template>

 <script>
  export default {
    data() {
      return {
        loggedIn: 0,
      }
    },
    async created() {
      const apiUrl = "http://25.93.216.221:8080";
      let apiEndPoint = apiUrl + "/";

    try{
      // let response = new FormData(document.getElementById("loginForm"));
      let response = await this.axios.get(apiEndPoint);
        console.log("Sukces", response.data);
        this.loggedIn = response.data;   
        // window.location.reload()
      } catch(e) {
        console.log('Error: ', e);
      }
    },
    methods: {
      logout() {
        let apiUrl = "http://25.93.216.221:8080";
        let apiEndPoint = apiUrl + "/signOut";
        this.axios.post(apiEndPoint, "")
        .then(response => {
          console.log("Sukces", response);
          this.status2 = response.data;
          window.location.reload()
        })
      }
    }
  }
 </script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
  margin: 0;
} 

#nav {
  padding: 30px;
  border-bottom: 1px solid black;

  a {
    font-weight: bold;
    color: #2c3e50;
    text-decoration: none;
  }
}

</style>
