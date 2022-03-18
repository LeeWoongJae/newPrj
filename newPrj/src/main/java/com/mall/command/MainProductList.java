package com.mall.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mall.common.Command;
import com.mall.product.ProductService;
import com.mall.product.ProductServiceImpl;
import com.mall.product.ProductVO;

public class MainProductList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// main page product list 출력 , 인기상품 체크된 제품만 출력
		response.setCharacterEncoding("utf-8");

		ProductService dao = new ProductServiceImpl();
		List<ProductVO> list = dao.productListPopular();
		int loopcnt  = list.size() > 4 ? 4:list.size();
		// json 생성
		JsonArray returnVal = new JsonArray();

		// 메인 페이지 출력할 제품 갯수
		for (int i = 0; i < loopcnt; i++) {
			JsonObject prod = new JsonObject();
			prod.addProperty("pname", list.get(i).getPname());
			prod.addProperty("image", list.get(i).getImage());
			prod.addProperty("price", list.get(i).getPrice());
			prod.addProperty("pcode", list.get(i).getPcode());

			returnVal.add(prod);
		}

		return "ajax:" + returnVal;
	}

}
