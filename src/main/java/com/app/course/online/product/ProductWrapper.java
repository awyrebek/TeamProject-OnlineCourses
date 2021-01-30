package com.app.course.online.product;

import com.google.gson.annotations.SerializedName;

public class ProductWrapper
{
	@SerializedName("product")
	   private Product product;

	public ProductWrapper()
	{
	}
	
	public ProductWrapper(Product product)
	{
		this.product = product;
	}
	
	   public Product getProduct() {
	      return product;
	   }

	   public void setProduct(Product product) {
	      this.product= product;
	   }
}
