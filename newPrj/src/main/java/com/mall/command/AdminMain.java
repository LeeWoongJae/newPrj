package com.mall.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.product.ProductService;
import com.mall.product.ProductServiceImpl;
import com.mall.product.ProductVO;

public class AdminMain implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// product 리스트 받아서 뿌리기
		response.setCharacterEncoding("utf-8");
		ProductService dao = new ProductServiceImpl();
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		list = dao.productList();
		request.setAttribute("prodList", list);
		
		
		return "admin/adminMain.tiles";
	}

}
