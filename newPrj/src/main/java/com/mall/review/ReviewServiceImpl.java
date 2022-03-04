package com.mall.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mall.common.DAO;
import com.mall.common.DAOclose;



public class ReviewServiceImpl implements ReviewService {
	Connection conn = DAO.getInstance();
	private DAOclose daOclose = new DAOclose();
	private PreparedStatement psmt ; 
	private ResultSet rs;
	
	
	@Override
	public List<ReviewVO> reviewList() {
		List<ReviewVO> revList = new ArrayList<>();
		ReviewVO   vo;
		String sql = "select * from review";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ReviewVO();
				vo.setReview_no(rs.getString("review_no"));
				vo.setUserId(rs.getString("userId"));
				vo.setRevContent(rs.getString("rev_content"));
				vo.setRevDate(rs.getString("rev_date"));
				
				
				revList.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				daOclose.close(rs, psmt, conn);
				
			}
		
		
		return revList;
	}

	@Override
	public ReviewVO reviewSelect(ReviewVO vo) {
		String sql = "select * from review where review_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getReview_no());
			
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setReview_no(rs.getString("review_no"));
				vo.setRevContent(rs.getString("rev_content"));
				vo.setRevDate(rs.getString("rev_date"));
				vo.setUserId(rs.getString("userId"));
			}
			
			
					
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		
		
		
		return vo;
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		String sql = "update review set rev_content=? where review_no=?";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getRevContent());
			psmt.setString(2, vo.getReview_no());
			
			
			n = psmt.executeUpdate();
					
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		return n;
	}

	@Override
	public int reviewInsert(ReviewVO vo) {
		String sql = "insert into review values(review_seq_no.NEXTVAL,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getRevContent());
			psmt.setString(3, vo.getRevDate());
			
			
			r= psmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return r;
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		String sql = "delete from review where review_no=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getReview_no());
			n = psmt.executeUpdate();
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		return n;
	}

}
