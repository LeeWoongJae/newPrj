package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.user.UserServiceImpl;
import com.mall.user.UserVO;

public class SignUp implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 페이지 이동

		
		return "user/signup.tiles";
	}

}
