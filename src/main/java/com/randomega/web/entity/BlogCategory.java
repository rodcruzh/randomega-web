package com.randomega.web.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlogCategory {

	@Id
	private BigInteger id;
	private String name;

	public BlogCategory() {
		super();
	}

	public BlogCategory(BigInteger id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public BlogCategory(BigInteger blogCategoryId) {
		super();
		this.id = blogCategoryId;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
