package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.product.ProductService;
import com.mall.product.ProductServiceImpl;

public class ProductList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 제품리스트 페이지 입니다
		ProductService dao = new ProductServiceImpl();
		
		String input = "";
		// category 값 받기
		if(request.getParameter("fc") != null) {
			String fc = "fc" + request.getParameter("fc");		
			request.setAttribute("fc", fc);
			input += fc;
		}
		if(request.getParameter("sc") != null) {
			String sc = "sc" + request.getParameter("sc");		
			request.setAttribute("sc", sc);			
			input += sc;
		}
		if(request.getParameter("tc") != null) {
			String tc = "tc" + request.getParameter("tc");			
			request.setAttribute("tc", tc);		
			input += tc;
		}		
		
		request.setAttribute("productList", dao.productListCate(input));

		
		return "product/productList.tiles";
	}

}
