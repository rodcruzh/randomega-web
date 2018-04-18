package com.randomega.web.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BlogEntry {

	@Id
	private BigInteger id;
	private String title;
	private String text;

	@ManyToOne
	private BlogCategory blogCategory;

	public BlogEntry() {
		super();
	}

	public BlogEntry(BigInteger id, String title, String text, BigInteger blogCategoryId) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.blogCategory = new BlogCategory(blogCategoryId);
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BlogCategory getBlogCategory() {
		return blogCategory;
	}

	public void setBlogCategory(BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}

}
