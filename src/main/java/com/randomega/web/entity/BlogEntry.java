package com.randomega.web.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "blog_entry")
public class BlogEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_blog_entry")
	private BigInteger id;

	@Column
	private String title;

	@Column
	private String subtitle;

	@Column(name = "date_published")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublished;

	@Column
	private String author;

	@Column
	private Integer visits;

	@Column
	private byte[] image;

	@Column
	private String text;

	@Column(name = "id_image")
	private String idImage;

	@JoinColumn(name = "id_blog_category", referencedColumnName = "id_blog_category")
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

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getIdImage() {
		return idImage;
	}

	public void setIdImage(String idImage) {
		this.idImage = idImage;
	}

}
