package com.mall.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.notice.NoticeService;
import com.mall.notice.NoticeServiceImpl;
import com.mall.notice.NoticeVO;

public class NoticeUpdate implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		NoticeVO vo = new NoticeVO();
		vo.setNoticeTitle(title);
		vo.setUserId(writer);
		vo.setNoticeContent(content);
		
		NoticeService service = new NoticeServiceImpl();
		service.noticeUpdate(vo);

		service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeList();

		request.setAttribute("list", list);

		return "notice/noticeList.tiles";
	}

}
