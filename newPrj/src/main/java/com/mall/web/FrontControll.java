package com.mall.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.command.AjaxLoginCheck;
import com.mall.command.LogOut;
import com.mall.command.Login;
import com.mall.command.LoginCheck;
import com.mall.command.NoticeInsert;
import com.mall.command.NoticeInsertCheck;
import com.mall.command.NoticePage;
import com.mall.command.NoticeViewPage;
import com.mall.command.ProductList;
import com.mall.command.ProductView;
import com.mall.command.SignUp;
import com.mall.command.SignUpCheck;
import com.mall.common.Command;
import com.mall.common.MainPage;

@WebServlet("*.do")
public class FrontControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 연결시켜 줄 hashMap 생성
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontControll() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		// 호출명 저장소 / com.mall.command package 에 넣으세요
		map.put("/main.do", new MainPage());
		map.put("/notice.do", new NoticePage());
		map.put("/noticeView.do", new NoticeViewPage());
		// login & signup
		map.put("/signup.do", new SignUp());
		map.put("/login.do", new Login());
		map.put("/loginCheck.do", new LoginCheck());
		map.put("/logOut.do", new LogOut());
		map.put("/signUp.do", new SignUp());
		map.put("/signUpCheck.do", new SignUpCheck());
		// product
		map.put("/productList.do", new ProductList());
		map.put("/productView.do", new ProductView());
		// map.put("loginCheck.do", new AjaxLoginCheck());
		
		
		
		// admin 환경에서  notice등록을 하는곳 (CKEditor)
		map.put("/noticeInsert.do", new NoticeInsert());
		map.put("/noticeInsertCheck.do", new NoticeInsertCheck());
		
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 처리할 Command 를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.run(request, response);
		
		if(viewPage != null) {
			if(viewPage.endsWith(".jsp")) {
				viewPage = "WEB-INF/jsp/" + viewPage;
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

}
