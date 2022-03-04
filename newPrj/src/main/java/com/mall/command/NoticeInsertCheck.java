package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.notice.NoticeService;
import com.mall.notice.NoticeServiceImpl;
import com.mall.notice.NoticeVO;

public class NoticeInsertCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		
		
		NoticeVO vo = new NoticeVO();
		vo.setNoticeTitle(title);
		vo.setUserId(writer);
		vo.setNoticeContent(content);
		
		
		NoticeService service = new NoticeServiceImpl();
		service.noticeInsert(vo);
		
		return "notice/noticeList.tiles";
	}

}
