package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "blog_category_entry")
public class BlogCategoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog_category_entry")
    private BigInteger id;

    @JoinColumn(name = "id_blog_category", referencedColumnName = "id_blog_category")
    @ManyToOne
    private BlogCategory blogCategory;

    @JoinColumn(name = "id_blog_entry", referencedColumnName = "id_blog_entry")
    @ManyToOne
    private BlogEntry blogEntry;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BlogCategory getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }

    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(BlogEntry blogEntry) {
        this.blogEntry = blogEntry;
    }

}
