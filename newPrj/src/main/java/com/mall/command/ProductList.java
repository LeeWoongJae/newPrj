package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;

public class ProductList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 제품리스트 페이지 입니다
		
		return "product/productList.tiles";
	}

}
