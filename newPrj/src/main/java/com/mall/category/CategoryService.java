package com.mall.category;

import java.util.List;

public interface CategoryService {
	int countAll();
	// selectAll
	List<CategoryVO> selectAll();
	// select
	CategoryVO select();
	// insert
	int insert(CategoryVO vo);
	// update
	int update(CategoryVO vo);
	// delete
	int delete(CategoryVO vo);
	
}
