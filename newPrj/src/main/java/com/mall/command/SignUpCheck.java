package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.user.UserServiceImpl;
import com.mall.user.UserVO;

public class SignUpCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리	
		UserServiceImpl dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		
		// ?userId=asdf&mailVal=naver.com&mail=naver.com&pwd=1234&tel=&address=&userName=
		
		vo.setUserId(request.getParameter("userId") + "@" + request.getParameter("mailVal"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setUserName(request.getParameter("userName"));
		vo.setTel(request.getParameter("tel"));
		vo.setAddress(request.getParameter("address"));
		
		// System.out.println("request 확인 " + request.getParameter("userId") + "@" + request.getParameter("mailVal"));
		
		dao.insertUser(vo);		
		
		return "user/signUpComplete.tiles";
	}

}
