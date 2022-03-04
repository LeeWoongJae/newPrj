package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.notice.NoticeService;
import com.mall.notice.NoticeServiceImpl;
import com.mall.notice.NoticeVO;

public class NoticeInsert implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "notice/noticeInsert.tiles";
	}

}
