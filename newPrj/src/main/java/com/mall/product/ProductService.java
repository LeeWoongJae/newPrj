package com.mall.product;

import java.util.List;

public interface ProductService {
	// selectAll
	List<ProductVO> productList();
	// select
	ProductVO productSelect(ProductVO vo);
	// update
	public int productUpdate(ProductVO vo);
	// insert
	public int productInsert(ProductVO vo);
	// delete
	public int productDelete(ProductVO vo);
}
