package com.mall.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.product.ProductService;
import com.mall.product.ProductServiceImpl;
import com.mall.product.ProductVO;

public class ProductContentUpdate implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		// ProductServiceImpl dao = new ProductServiceImpl();
		// List<ProductVO> list = new ArrayList();
		
		String image = request.getParameter("image");
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String deliveryFee = request.getParameter("deliveryFee");
		String madein= request.getParameter("madein");
		String pcode = request.getParameter("pcode");
		
		
		ProductVO vo = new ProductVO();
		vo.setImage(image);
		vo.setPname(pname);
		vo.setPrice(price);
		vo.setdeliveryFee(deliveryFee);
		vo.setMadein(madein);
		vo.setPcode(pcode);
		
		ProductService service = new ProductServiceImpl();
		service.productUpdate(vo);
		
		
		service = new ProductServiceImpl();
		List<ProductVO> list  = service.productList();
		
		request.setAttribute("list", list);
		
	
		
		return "product/productContentUpdate.tiles";
		
		
	
	}

}
