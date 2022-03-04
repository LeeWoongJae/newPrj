package com.mall.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.product.ProductServiceImpl;
import com.mall.product.ProductVO;

public class ProductPage implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		
		ProductServiceImpl dao = new ProductServiceImpl();
		List<ProductVO> list = new ArrayList();
		
		list = dao.productList();
		
		request.setAttribute("productList", list);
		
		
		
		
		
		return "product/productList.tiles";
	}

}
