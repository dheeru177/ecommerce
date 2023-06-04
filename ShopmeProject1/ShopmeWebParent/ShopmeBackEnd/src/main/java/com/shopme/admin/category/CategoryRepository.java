package com.shopme.admin.category;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shopme.common.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
	
	@Query("select c from Category c where c.parent.id is NULL")
	public List<Category> findRootCategories();
	
	
	
	@Query("UPDATE Category u SET u.enabled = ?2 where u.id =?1")
	@Modifying
	public void updateCategoryEnabledStatus(Integer Id  , boolean enabled	);


	public Long countById(Integer id);

	public Category findByName(String name);
	
	public Category findByAlias(String alias);
	
	

}
