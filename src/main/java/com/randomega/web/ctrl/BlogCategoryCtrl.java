package com.randomega.web.ctrl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.randomega.web.entity.BlogCategory;
import com.randomega.web.svc.BlogCategorySvc;

/**
 * GET /entries Get all the blog categories <br>
 * GET /entries/id Get the blog category <br>
 * POST /entries Create new blog category <br>
 * PUT /entries/id Update the blog category <br>
 * DELETE /entries/id Delete the blog category
 * 
 * @author rcruzh
 *
 */
@RestController
public class BlogCategoryCtrl {

	@Autowired
	private BlogCategorySvc blogCategorySvc;

	@RequestMapping("/categories")
	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost" })
	public List<BlogCategory> getAllBlogCategories() {
		return blogCategorySvc.getAllBlogCategories();
	}

	@RequestMapping("/categories/{id}")
	public BlogCategory getBlogCategory(@PathVariable BigInteger id) {
		return blogCategorySvc.getBlogCategory(id);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public void addBlogCategories(@RequestBody BlogCategory blogCategory) {
		blogCategorySvc.addBlogCategory(blogCategory);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
	public void updateBlogCategory(@PathVariable BigInteger id, @RequestBody BlogCategory blogCategory) {
		blogCategorySvc.updateBlogCategory(id, blogCategory);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
	public void deleteBlogCategory(@PathVariable BigInteger id) {
		blogCategorySvc.deleteBlogCategory(id);
	}

}
