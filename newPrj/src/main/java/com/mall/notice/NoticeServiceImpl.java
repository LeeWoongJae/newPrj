package com.mall.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mall.common.DAO;
import com.mall.common.DAOclose;

public class NoticeServiceImpl implements NoticeService {	
	private DAOclose daOclose = new DAOclose();
	private Connection conn = DAO.getInstance();
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<NoticeVO> noticeList() {
		// 전체리스트
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		
		String sql = "SELECT * FROM NOTICE";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setNoticeNo(rs.getString("notice_no"));
				vo.setNoticeTitle(rs.getString("notice_title"));
				vo.setNoticeContent(rs.getString("notice_content"));
				vo.setUserId(rs.getString("user_id"));
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {			
			daOclose.close(rs, psmt, conn);
		}	
		
		return list;
	}
	
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// 단건조회
		String 
		
		return null;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
