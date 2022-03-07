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
		String sql = "SELECT * FROM NOTICE WHERE NOTICE_NO = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getNoticeNo());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setNoticeNo(rs.getString("notice_no"));
				vo.setNoticeTitle(rs.getString("notice_title"));
				vo.setNoticeContent(rs.getString("notice_content"));
				vo.setUserId(rs.getString("user_id"));
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return vo;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// 수정
		// 테스트 후 notice_title, notice_content 수정할 예정
		String sql = "UPDATE NOTICE SET NOTICE_TITLE = ? WHERE NOTICE_NO = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNoticeTitle());
			psmt.setString(2, vo.getNoticeNo());
			rs = psmt.executeQuery();
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return n;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// 삽입 (seq 자동증가, user_id, notice_title, notice_content);
		String sql = "insert into notice values (NOTICE_SEQ_NO.nextval, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getNoticeTitle());
			psmt.setString(3, vo.getNoticeContent());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return n;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// 삭제
		String sql = "delete from notice where notice_seq_no = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNoticeNo());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return n;
	}


}
