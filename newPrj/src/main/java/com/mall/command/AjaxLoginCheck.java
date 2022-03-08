package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.user.UserService;
import com.mall.user.UserServiceImpl;

public class AjaxLoginCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("id"));
		
		UserService dao = new UserServiceImpl();
		boolean check = dao.idCheck(request.getParameter("id"));
		System.out.println(check);
		
		String returnVal;
		if(check != false) {
			returnVal = "true";
		} else {
			returnVal = "false";
		}
		
		return "ajax:" + returnVal;
	}

}
