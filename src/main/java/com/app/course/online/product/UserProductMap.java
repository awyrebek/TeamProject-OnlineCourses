package com.app.course.online.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.course.online.user.User;

@Entity
@Table(name = "userProductMap")
public class UserProductMap
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	@OneToOne
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private Product product;
	
	
	public Long getId()
	{ return id; }
	public void setId(Long id)
	{ this.id = id; }
	public User getUser()
	{ return user; }
	public void setUser(User user)
	{ this.user = user; }
	public Product getProduct()
	{ return product; }
	public void setProduct(Product product)
	{ this.product = product; }
}
