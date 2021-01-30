<template>
  <div class="productlist">
    <h1>My Tutorials</h1>
    <hr>
    <div class="CardProduct" v-for="(tutorial, index) in tutorials" :key="index">
      <CardProduct 
        :id="tutorial.product.id" 
        :title="tutorial.product.title" 
        :money="tutorial.product.money" 
        :description="tutorial.product.description" 
        :video="tutorial.product.video"
        />
        <iframe width="420" height="315"
          src="https://www.youtube.com/embed/tgbNymZ7vqY">
        </iframe>
    </div>
  </div>  
</template>


<script>
const apiUrl = "http://25.93.216.221:8080";
let apiEndPoint = apiUrl + "/getAllUserProducts";

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