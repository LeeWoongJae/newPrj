package com.mall.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.notice.NoticeServiceImpl;
import com.mall.notice.NoticeVO;

public class NoticePage implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NoticeServiceImpl dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		list = dao.noticeList();
		// System.out.println(list);
		
		request.setAttribute("noticeList", list);
		
		return "notice/noticeList.tiles";
	}

}
