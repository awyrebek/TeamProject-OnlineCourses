<template>
    <div class="addProduct">
        <v-form v-model="valid">
        <hr>
        <h1> Add Product</h1>
            <v-container>
            <form id="AddProductForm">
                <v-row class="d-flex justify-content-center">
                    <v-col cols="12" md="4">
                        <v-text-field
                            type="title"
                            id="title"
                            v-model="title"
                            label="Title"
                            name="title"
                            required
                        ></v-text-field>
                        <v-text-field
                            type="description"
                            id="description"
                            v-model="description"
                            label="Short description"
                            name="description"
                            required
                        ></v-text-field>
                        <v-text-field
                            type="video"
                            id="video"
                            v-model="video"
                            label="VideoURL"
                            name="video"
                            required
                        ></v-text-field>
                        <v-text-field
                            type="money"
                            id="money"
                            v-model="money"
                            label="Price"
                            name="money"
                            required
                        ></v-text-field>
                    </v-col>
                </v-row>

                <v-flex class="button text-xs-center" mt-5>
                    <v-btn  v-on:click.prevent="post();" :disabled="!canAdd" type="submit">Add Tutorial</v-btn>
                </v-flex>
                <!-- <div class="status mt-3">{{status}}</div>   -->
            </form>
            </v-container>
        </v-form>
        <vue-ellipse-progress v-show="showCircle" :progress="progress"/>
    </div>
</template>

<script>
const apiUrl = "http://25.93.216.221:8080";
let apiEndPoint = apiUrl + "/addProduct";

export default {
    data() {
        return {
            title: '',
            description: '',
            video: '',
            money: '',
            status: '',
            progress: 0,
            showCircle: false
        }
    },
    computed: {
      canAdd() {
          return this.title.trim().length >= 3 && this.description.trim().length >=3 && this.video.trim().length >=3;
      }
  },
  
  
  methods: {
    async post() {
      let formData = new FormData(document.getElementById("AddProductForm"));
      let response = await this.axios.post(apiEndPoint, formData);
      console.log("Sukces", response); 
    showCircle = true;
      this.progress = 100;           
      setTimeout(function(){       
          window.location.reload(); 
        }, 1000);
    },
  }
}
</script>