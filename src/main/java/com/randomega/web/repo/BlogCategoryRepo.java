package com.randomega.web.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.randomega.web.entity.BlogCategory;

public interface BlogCategoryRepo extends CrudRepository<BlogCategory, BigInteger> {

}
