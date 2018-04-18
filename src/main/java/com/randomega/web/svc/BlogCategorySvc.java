package com.randomega.web.svc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomega.web.entity.BlogCategory;
import com.randomega.web.repo.BlogCategoryRepo;

@Service
public class BlogCategorySvc {

	@Autowired
	private BlogCategoryRepo blogCategoryRepo;

	public List<BlogCategory> getAllBlogCategories() {
		List<BlogCategory> blogCategories = new ArrayList<>();
		blogCategoryRepo.findAll().forEach(blogCategories::add);
		return blogCategories;
	}

	public BlogCategory getBlogCategory(BigInteger id) {
		Optional<BlogCategory> b = null;
		if ((b = blogCategoryRepo.findById(id)).isPresent())
			return b.get();
		else
			return null;
	}

	public void addBlogCategory(BlogCategory blogCategory) {
		blogCategoryRepo.save(blogCategory);
	}

	public void updateBlogCategory(BigInteger id, BlogCategory blogCategory) {
		blogCategoryRepo.save(blogCategory);
	}

	public void deleteBlogCategory(BigInteger id) {
		blogCategoryRepo.deleteById(id);
	}

}
