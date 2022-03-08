package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mall.common.Command;
import com.mall.user.UserServiceImpl;
import com.mall.user.UserVO;

public class LoginCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 후 화면이동
		UserServiceImpl dao = new UserServiceImpl();
		// System.out.println(id + " " + pwd);
		HttpSession session = request.getSession();
		// 입력되어지는 ID
		String id = request.getParameter("userId");
		// 입력되어지는 PWD
		String pwd = request.getParameter("pwd");
		
		UserVO vo = new UserVO();
		vo.setUserId(id);
		vo.setPwd(pwd);
		
		vo = dao.loginCheck(vo);
		
		System.out.println(vo.getAddress());
		request.setAttribute("user", vo);
		
		String viewPage;
		if(vo.getUserId() != null) {
			session.setAttribute("id", vo.getUserId());
			viewPage = "user/loginCheck.tiles";
		} else {
			viewPage = "main/main.tiles";
		}
		
		// 로그인 후 이동할 화면
		return viewPage;
	}

}
