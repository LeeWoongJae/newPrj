package com.mall.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.category.CategoryService;
import com.mall.category.CategoryServiceImpl;
import com.mall.category.CategoryVO;
import com.mall.common.Command;
import com.mall.product.ProductService;
import com.mall.product.ProductServiceImpl;

public class ProductList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 제품리스트 페이지 입니다
		ProductService dao = new ProductServiceImpl();
		CategoryService daoCate = new CategoryServiceImpl();
		
		String input = "";
		CategoryVO vo = new CategoryVO();
		// category 값 받기
		if(request.getParameter("fc") != null) {
			String fc = request.getParameter("fc");
			vo.setFc(fc);
			fc = "fc" + fc;
			request.setAttribute("fc", fc);
			input += fc;
		} else {
			String fc = "null";
			vo.setFc(fc);
		}
		if(request.getParameter("sc") != null) {
			String sc = request.getParameter("sc");		
			vo.setSc(sc);
			sc = "sc" + sc;
			request.setAttribute("sc", sc);			
			input += sc;
		} else {
			String sc = "null";
			vo.setSc(sc);
		}
		if(request.getParameter("tc") != null) {
			String tc = request.getParameter("tc");			
			vo.setTc(tc);
			tc = "tc" + tc;
			request.setAttribute("tc", tc);		
			input += tc;
		} else {
			String tc = "null";			
			vo.setTc(tc);
		}
		
		System.out.println("fc:" + vo.getFc());
		System.out.println("sc:" + vo.getSc());
		System.out.println("tc:" + vo.getTc());
		
		request.setAttribute("categoryList", daoCate);
		
		request.setAttribute("productList", dao.productListCate(input));
		
		System.out.println();
		
		return "product/productList.tiles";
	}

}
