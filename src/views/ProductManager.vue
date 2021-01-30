<template>
  <div class="productlist">
    <h1>Product Manager</h1>

    <div class="addForm">
        <AddProduct/>
    </div>
    <hr>
    <div class="CardProduct" v-for="(tutorial, index) in tutorials" :key="index">
      <CardProduct 
        :id="tutorial.product.id" 
        :title="tutorial.product.title" 
        :money="tutorial.product.money" 
        :description="tutorial.product.description" 
        :video="tutorial.product.video"
        
        />
        <b-button 
            href="#" 
            variant="danger" 
            size="sm" 
            class="mt-3"
            id="removeButton"
            @click="remove(tutorial.product.id); update(index)">
            Delete 
        </b-button>
    </div>
  </div>
</template>


<script>
const apiUrl = "http://25.93.216.221:8080";

import CardProduct from '@/components/CardProduct.vue'
import AddProduct from '@/components/AddProduct.vue'
export default {

  data() {
    return {
      tutorials: [] 
    }
  },
  components: {
    CardProduct,
    AddProduct
  },
 async created() {     
    let apiEndPoint = apiUrl + "/getAllProducts";

  try {
      let response = await this.axios.get(apiEndPoint);
        console.log("Sukces", response.data);
        this.tutorials = response.data;   
      } catch(e) {
        console.log('Error: ', e);
      }
  },
  methods: {
    async remove(index) {
        let apiEndPoint = apiUrl + "/deleteProduct";
        let response = await this.axios.post(apiEndPoint, index);
        console.log("SukcesSSSS", response);
        console.log("lalalal2 " + index);
    },
    async update(index) {
        await this.$delete(this.tutorials, index);
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