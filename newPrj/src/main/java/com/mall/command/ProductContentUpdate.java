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
		
		// pcode
		String pcode = request.getParameter("pcode");
		
		ProductService daoProd = new ProductServiceImpl();
		
		// 카테고리 param 불러오기
		CategoryService daoCateFc = new CategoryServiceImpl();
		CategoryService daoCateSc = new CategoryServiceImpl();
		CategoryService daoCateTc = new CategoryServiceImpl();
				

		
//		CategoryVO catevofc = new CategoryVO();
//		catevofc.setFc(fc);
//		
//		CategoryVO catevosc = new CategoryVO();
//		catevofc.setFc(fc);
//		catevosc.setSc(sc);
//		
//		CategoryVO catevotc = new CategoryVO();
//		catevotc.setFc(fc);
//		catevotc.setSc(sc);
//		
//		CategoryService cateServicefc = new CategoryServiceImpl();
//		cateServicefc.update(catevofc);
//		
//		CategoryService cateServicesc = new CategoryServiceImpl();
//		cateServicesc.update(catevosc);
//		
//		CategoryService cateServicetc = new CategoryServiceImpl();
//		cateServicetc.update(catevotc);
			
		
		// cateService = new CategoryServiceImpl();
		// List<CategoryVO> listFc  = cateService.cateFcList(fc);
//		List<CategoryVO> listSc  = cateService.cateFcList(sc);
//		List<CategoryVO> listTc  = cateService.cateFcList(tc);
		
		// productList param

		
		// productList vo setting
		ProductVO vo = new ProductVO();
		vo.setPcode(pcode);

		vo = daoProd.productSelect(vo);
		
		String fcStr = vo.getCategory().substring(2, 4);
		
		String scStr = vo.getCategory().substring(7, 9);
		
		//String tcStr = vo.getCategory().substring(10,14);
		
//		String scStr = vo.getCategory();
//		String tcStr = vo.getCategory();
		
		List<CategoryVO> listFc = daoCateFc.cateFcList();
		List<CategoryVO> listSc = daoCateSc.cateScList(fcStr);
		List<CategoryVO> listTc = daoCateTc.cateTcList(fcStr, scStr);
		
		// productList update시키기
		// ProductService service = new ProductServiceImpl();
		// service.productUpdate(vo);
		
		
		// update시킨 데이터를 list형태로  
		// service = new ProductServiceImpl();
		// List<ProductVO> list  = service.productList();
		
		
		request.setAttribute("product", vo);
		
		
		
		request.setAttribute("categoryFcList", listFc);
		request.setAttribute("categoryScList", listSc);
		request.setAttribute("categoryTcList", listTc);
		

	
		
		return "product/productContentUpdate.tiles";
		
		
	
	}

}
