<template>
    <div class="product">
        <div>
            <!-- <div class="product id"> {{id}} </div> -->
            <div class="product title"> {{title}} </div>
            <div class="product description"> {{description}} </div>
            <div class="product id"> Price <b>{{money}} $ </b> </div>
            <div class="product id">{{video}}</div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        id: {
            type: Number,
            required: true
        },
        money: {
            type: Number,
            required: true
        },
        description: {
            type: String,
            required: true
        },
        title: {
            type: String,
            required: true
        },
        video: {
            type: String,
            required: true
        },
    }
}
</script>

<style lang="less" scoped>
    .product {
        font-size: 14px;
    }
    .product.title {
        font-size: 30px;
        margin-bottom: 12px;
    }
    .product.id {
        font-size: 20px;
    }
</style>