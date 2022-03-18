package com.mall.category;

import java.util.List;

public interface CategoryService {
	int countAll();
	// selectAll
	List<CategoryVO> selectAll();
	// select
	CategoryVO select(CategoryVO vo);
	// insert
	int insert(CategoryVO vo);
	// update
	int update(CategoryVO vo);
	// delete
	int delete(CategoryVO vo);
	
	// category Fc select
	List<CategoryVO> cateFcList();
	// category Sc select
	List<CategoryVO> cateScList(String cateFc );
	// category Tc select
	List<CategoryVO> cateTcList(String cateFc , String cateSc);
	
}
