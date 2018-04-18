package com.randomega.web.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.randomega.web.entity.BlogEntry;

public interface BlogEntryRepo extends CrudRepository<BlogEntry, BigInteger> {

	public List<BlogEntry> findByBlogCategoryId(BigInteger blogCategoryId);
	
}
