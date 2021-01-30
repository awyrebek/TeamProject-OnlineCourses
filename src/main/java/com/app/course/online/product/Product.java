package com.app.course.online.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@OneToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "id")
	private Category category;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "video")
	private String video;
	@Column(name = "money")
	private BigDecimal money;
	
	public Long getId()
	{ return id; }
	public void setId(Long id)
	{ this.id = id; }
	public Category getCategory()
	{ return category; }
	public void setCategory(Category category)
	{ this.category = category; }
	public String getTitle()
	{ return title; }
	public void setTitle(String title)
	{ this.title = title; }
	public String getDescription()
	{ return description; }
	public void setDescription(String description)
	{ this.description = description; }
	public String getVideo()
	{ return video; }
	public void setVideo(String video)
	{ this.video = video; }
	public BigDecimal getMoney()
	{ return money; }
	public void setMoney(BigDecimal money)
	{ this.money = money; }
}
