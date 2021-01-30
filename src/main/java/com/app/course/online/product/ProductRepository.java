package com.app.course.online.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("productRepository")
public interface ProductRepository  extends JpaRepository<Product, Integer>
{
	public Product findById(Long id);
	public Product findByTitle(String title);
}
