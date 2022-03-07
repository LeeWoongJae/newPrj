package com.mall.command;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mall.category.CategoryService;
import com.mall.category.CategoryServiceImpl;
import com.mall.category.CategoryVO;
import com.mall.common.Command;


public class MenuList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		
		String idString = request.getParameter("id");
		System.out.println(idString);
		
		CategoryService dao = new CategoryServiceImpl();
		List<CategoryVO> list = dao.selectAll();
		
		// 출력 갯수
		int n = list.size();
		System.out.println(n);
		
		// 최종 반환값
		JsonArray returnVal = new JsonArray();
		
		// json 만들기
		Gson gson = new Gson();		
		
		for(int i=0; i<n; i++) {
			JsonObject cate1 = new JsonObject();
			// first category
			cate1.addProperty("fcCode", list.get(i).getFc());
			cate1.addProperty("fcName", list.get(i).getFcName());
			
			JsonArray cate2List = new JsonArray();
			
			// second category
			JsonObject cate2 = new JsonObject();
			cate2.addProperty("scCode", list.get(i).getSc());
			cate2.addProperty("scName", list.get(i).getScName());
			
			// third category
			JsonArray cate3List = new JsonArray();
			JsonObject cate3 = new JsonObject();
			cate3.addProperty("tcCode", list.get(i).getTc());
			cate3.addProperty("tcName", list.get(i).getTcName());
			
			cate3List.add(cate3);
			
			cate2.add("tc", cate3List);
			
			cate2List.add(cate2);
			cate1.add("sc", cate2List);				
			
			returnVal.add(cate1);
		}
		
		
		System.out.println(returnVal);
		
		return "ajax:" + returnVal;
	}

}
