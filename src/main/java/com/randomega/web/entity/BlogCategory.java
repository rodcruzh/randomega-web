package com.randomega.web.entity;

import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table(name = "blog_category")
public class BlogCategory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog_category")
	private BigInteger id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String acronym;

	@Column
	private Boolean active;

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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
