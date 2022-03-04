package com.mall.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.Command;
import com.mall.notice.NoticeServiceImpl;
import com.mall.notice.NoticeVO;

public class NoticeViewPage implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NoticeServiceImpl dao = new NoticeServiceImpl();
		
		NoticeVO temp = new NoticeVO();
		temp.setNoticeNo(request.getParameter("noticeNo"));
		// System.out.println("temp : " + temp.getNoticeNo());
		
		NoticeVO vo = new NoticeVO();
		vo = dao.noticeSelect(temp);
		//System.out.println("vo.noticeNo : " + vo.getNoticeNo());
		//System.out.println("vo.title : " + vo.getNoticeTitle());
		//System.out.println("vo.content : " + vo.getNoticeContent());
		//System.out.println("vo.userid : " + vo.getUserId());
		
		// String noticeNo = request.getParameter("noticeNo");
				
		request.setAttribute("vo", vo);
		
		return "notice/noticeView.tiles";
	}

}
