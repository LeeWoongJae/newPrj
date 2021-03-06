package com.mall.command;

import java.util.List;

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
		
		NoticeVO vo = new NoticeVO(); // getter and setter
		NoticeService service = new NoticeServiceImpl(); //C R U D S I 
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		
		
		vo.setNoticeTitle(title);
		vo.setUserId(writer);
		vo.setNoticeContent(content);
		
		
		service.noticeInsert(vo);
		
		
		
		// 타일즈로 띄우면 결과쪽으로만 값을 보내어서 결과값이 나오지 않아
		// return "notice/noticeList.tiles";
		
		// 전체 리스트페이지를 뽑도록 공지사항 화면으로 가기로 만듦
		return "notice.do";
	}

}
