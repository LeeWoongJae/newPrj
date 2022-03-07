package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.product.ProductServiceImpl;
import com.mall.product.ProductVO;

public class ProductView implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 제품상세페이지로 넘어감
		ProductServiceImpl dao = new ProductServiceImpl();
		
		ProductVO temp = new ProductVO();
		temp.setPcode(request.getParameter("pcode"));
		
		ProductVO vo = new ProductVO();
		vo = dao.productSelect(temp);
		
		request.setAttribute("vo", vo);
		
		return "product/productView.tiles";
	}

}
