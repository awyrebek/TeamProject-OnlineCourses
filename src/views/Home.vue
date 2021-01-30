<template>
  <div class="home">    
    <img alt="Vue logo" src="../assets/bg.jpg">
    <h1>Kursy</h1>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  data() {
    return {
      title: ''
    }
  },
  
  async created() {    
    try {
      let {data} = await this.axios.get('http://25.93.216.221:8080');
      this.title = data;
      console.log('async sukces', response);
    } catch(e) {
      console.log('BŁĄD', e);
    }
  },
  components: {
    HelloWorld,
  },
};
</script>
<style lang="less" scoped>
  .home {
    position: relative;
  }

  img {
    width: 100%;
    height: calc(100vh - 97px);
    filter: brightness(50%);
  }
  
  h1 {
    position: absolute;
    width: 100%;
    display: flex;
    justify-content: center;
    top: 70px;
    color: #FFFFFF;
    z-index: 2;
    text-transform: uppercase;
    font-size: 90px;
    font-weight: 700;
    font-family: "Times New Roman";
  }
</style>
