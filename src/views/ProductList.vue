<template>
  <div class="productlist">
    <h1>Tutorial List</h1>
    <hr>
    <div class="CardProduct" v-for="(tutorial, index) in tutorials" :key="index">
      <CardProduct 
        :id="tutorial.product.id" 
        :title="tutorial.product.title" 
        :money="tutorial.product.money" 
        :description="tutorial.product.description" 
        />
        <b-button 
            href="#" 
            variant="success" 
            size="sm" 
            class="mt-3"
            @click="purchase(tutorial.product.id)">
            Purchase 
        </b-button>
    </div>
  </div>
</template>


<script>
const apiUrl = "http://25.93.216.221:8080";
let apiEndPoint = apiUrl + "/getAllProducts";

import CardProduct from '@/components/CardProduct.vue'
export default {

  data() {
    return {
      tutorials: []
    }
  },
  components: {
    CardProduct
  },
 async created() {
  try{
      // let response = new FormData(document.getElementById("loginForm"));
      let response = await this.axios.get(apiEndPoint);
        console.log("Sukces", response.data);
        this.tutorials = response.data;   
      } catch(e) {
        console.log('Error: ', e);
      }
  },
  methods: {
    async purchase(index) {
        let apiEndPoint = apiUrl + "/addProductToUser";
        let response = await this.axios.post(apiEndPoint, index);
        console.log("SukcesSSSS", response);
        console.log("lalalal2 " + index);
    },
  }
}
</script>

<style scoped lang="less">
  h1 {
    margin-top: 20px;
    margin-bottom: 20px;
  }
  .CardProduct{
    background: #323a4f;
    border-radius: 27px;
    margin: 20px 30px;
    padding: 20px;
    color: white;
  }
</style>