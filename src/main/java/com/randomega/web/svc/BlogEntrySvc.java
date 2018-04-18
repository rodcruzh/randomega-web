package com.randomega.web.svc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomega.web.entity.BlogEntry;
import com.randomega.web.repo.BlogEntryRepo;

@Service
public class BlogEntrySvc {

	@Autowired
	private BlogEntryRepo blogEntryRepo;

	// private List<BlogEntry> blogEntries = new ArrayList<>(
	// Arrays.asList(new BlogEntry(BigInteger.valueOf(1L), "Welcome!", "Welcome to
	// RO."),
	// new BlogEntry(BigInteger.valueOf(2L), "What's next?", "See what is next.")));

	public List<BlogEntry> getAllBlogEntries(BigInteger blogCategoryId) {
		// return blogEntries;
		List<BlogEntry> blogEntries = new ArrayList<>();
		blogEntryRepo.findByBlogCategoryId(blogCategoryId).forEach(blogEntries::add);
		return blogEntries;
	}

	public BlogEntry getBlogEntry(BigInteger id) {
		// return blogEntries.stream().filter(b ->
		// b.getId().equals(id)).findFirst().get();
		Optional<BlogEntry> b = null;
		if ((b = blogEntryRepo.findById(id)).isPresent())
			return b.get();
		else
			return null;
	}

	public void addBlogEntry(BlogEntry blogEntry) {
		// blogEntries.add(blogEntry);
		blogEntryRepo.save(blogEntry);
	}

	public void updateBlogEntry(BigInteger id, BlogEntry blogEntry) {
		// for (int i = 0; i < blogEntries.size(); i++) {
		// BlogEntry b = blogEntries.get(i);
		// if (b.getId().equals(id)) {
		// blogEntries.set(i, blogEntry);
		// return;
		// }
		// }
		blogEntryRepo.save(blogEntry);
	}

	public void deleteBlogEntry(BigInteger id) {
		// blogEntries.removeIf(b -> b.getId().equals(id));
		blogEntryRepo.deleteById(id);
	}

}
