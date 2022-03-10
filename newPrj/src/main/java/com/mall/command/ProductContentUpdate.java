package com.mall.command;

import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.category.CategoryService;
import com.mall.category.CategoryServiceImpl;
import com.mall.category.CategoryVO;
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
		
		
//		CategoryService daoCate = new CategoryServiceImpl();
		
		
		
		String image = request.getParameter("image");
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String deliveryFee = request.getParameter("deliveryFee");
		String madein= request.getParameter("madein");
		String pcode = request.getParameter("pcode");
		String stock = request.getParameter("stock");
		
		ProductVO pvo = new ProductVO();
		pvo.setImage(image);
		pvo.setPname(pname);
		pvo.setPrice(price);
		pvo.setdeliveryFee(deliveryFee);
		pvo.setMadein(madein);
		pvo.setPcode(pcode);
		pvo.setStock(stock);
		
		ProductService service = new ProductServiceImpl();
		service.productUpdate(pvo);
		
		
		
		service = new ProductServiceImpl();
		List<ProductVO> list  = service.productList();
		
	
//		String input = "";
//		CategoryVO catevo = new CategoryVO();
//		// category 값 받기
//		if(request.getParameter("fc") != null) {
//			String fc = request.getParameter("fc");
//			catevo.setFc(fc);
//			fc = "fc" + fc;
//			request.setAttribute("fc", fc);
//			input += fc;
//		} else {
//			String fc = "null";
//			catevo.setFc(fc);
//		}
//		if(request.getParameter("sc") != null) {
//			String sc = request.getParameter("sc");		
//			catevo.setSc(sc);
//			sc = "sc" + sc;
//			request.setAttribute("sc", sc);			
//			input += sc;
//		} else {
//			String sc = "null";
//			catevo.setSc(sc);
//		}
//		if(request.getParameter("tc") != null) {
//			String tc = request.getParameter("tc");			
//			catevo.setTc(tc);
//			tc = "tc" + tc;
//			request.setAttribute("tc", tc);		
//			input += tc;
//		} else {
//			String tc = "null";			
//			catevo.setTc(tc);
//		}
		
		
		
		request.setAttribute("list", list);
//		request.setAttribute("catelist", daoCate.select(catevo));
	
		
		return "product/productContentUpdate.tiles";
		
		
	
	}

}
