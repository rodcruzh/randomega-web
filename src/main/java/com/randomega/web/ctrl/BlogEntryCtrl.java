package com.randomega.web.ctrl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.randomega.web.entity.BlogCategory;
import com.randomega.web.entity.BlogEntry;
import com.randomega.web.svc.BlogEntrySvc;

/**
 * GET /entries Get all the blog entries <br>
 * GET /entries/id Get the blog entry <br>
 * POST /entries Create new blog entry <br>
 * PUT /entries/id Update the blog entry <br>
 * DELETE /entries/id Delete the blog entry
 * 
 * @author rcruzh
 *
 */
@RestController
public class BlogEntryCtrl {

	@Autowired
	private BlogEntrySvc blogEntrySvc;

	@RequestMapping("/categories/{blogCategoryId}/entries")
	public List<BlogEntry> getAllBlogEntries(@PathVariable BigInteger blogCategoryId) {
		return blogEntrySvc.getAllBlogEntries(blogCategoryId);
	}

	@RequestMapping("/categories/{blogCategoryId}/entries/{id}")
	public BlogEntry getBlogEntry(@PathVariable BigInteger id) {
		return blogEntrySvc.getBlogEntry(id);
	}

	@RequestMapping(value = "/categories/{blogCategoryId}/entries", method = RequestMethod.POST)
	public void addBlogEntry(@RequestBody BlogEntry blogEntry, @PathVariable BigInteger blogCategoryId) {
		blogEntry.setBlogCategory(new BlogCategory(blogCategoryId));
		blogEntrySvc.addBlogEntry(blogEntry);
	}

	@RequestMapping(value = "/categories/{blogCategoryId}/entries/{id}", method = RequestMethod.PUT)
	public void updateBlogEntry(@PathVariable BigInteger blogCategoryId, @PathVariable BigInteger id,
			@RequestBody BlogEntry blogEntry) {
		blogEntry.setBlogCategory(new BlogCategory(blogCategoryId));
		blogEntrySvc.updateBlogEntry(id, blogEntry);
	}

	@RequestMapping(value = "/categories/{blogCategoryId}/entries/{id}", method = RequestMethod.DELETE)
	public void deleteBlogEntry(@PathVariable BigInteger blogCategoryId, @PathVariable BigInteger id) {
		blogEntrySvc.deleteBlogEntry(id);
	}

}
