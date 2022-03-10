package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.orderDetail.OrderDetailService;
import com.mall.orderDetail.OrderDetailServiceImpl;
import com.mall.orderDetail.OrderDetailVO;

import freemarker.ext.beans.BeansWrapper;

public class CartList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 카트담기
		
		// request 값 받기
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String image = request.getParameter("image");
		String pcnt = request.getParameter("pcnt");	
		String price = request.getParameter("price");
		
		String pcolor = "";
		if(request.getParameter("pcolor0") != null) {
			pcolor = pcolor + request.getParameter("pcolor0") + " ";
		}
		if(request.getParameter("pcolor1") != null) {
			pcolor = pcolor + request.getParameter("pcolor1") + " ";
		}
		if(request.getParameter("pcolor2") != null) {
			pcolor = pcolor + request.getParameter("pcolor2" + " "); 
		}
		
		String psize = "";
		if(request.getParameter("psize0") != null) {
			psize = psize + request.getParameter("psize0") + " ";
		}
		if(request.getParameter("psize1") != null) {
			psize = psize + request.getParameter("psize1") + " ";
		}
		if(request.getParameter("psize2") != null) {
			psize = psize + request.getParameter("psize2") + " ";
		}		
		
		//System.out.println("pcode:" + pcode + " | pname:" + pname + " | image:" + image + " | pcnt:" + pcnt + " | price:" + price);
		
		// vo 생성
		OrderDetailVO vo = new OrderDetailVO();
		vo.setOrderStatus("배송대기");
		vo.setoPname(pname);
		vo.setoColor(pcolor);
		vo.setoSize(psize);
		vo.setoCnt(pcnt);
		vo.setoPrice(price);
		vo.setpCode(pcode);
		
		System.out.println(vo.getoPname());
		
		OrderDetailService dao = new OrderDetailServiceImpl();
		int n = dao.orderDetailInsert(vo);
		System.out.println("수행결과 확인 : " + n);
		
		return "product/cartList.tiles";
	}

}
