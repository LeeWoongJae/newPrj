package com.mall.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mall.common.DAO;

public class UserServiceImpl extends DAO implements UserSevice {

		private PreparedStatement pstmt ; 
		private ResultSet rs;
		
	
	
	@Override
	public List<userVO> selectAllList() {
		List<userVO> users = new ArrayList();
		userVO vo;
		String sql = "select * from users";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo  = new userVO();
				vo.setUser_id(rs.getString("user_id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setUserName(rs.getString("userName"));
				vo.setIs_withRaw(rs.getString("is_withraw"));
				vo.setAuthor(rs.getString("author"));
				vo.setRegDate(rs.getString("regdate"));
				
				users.add(vo);
				
				
			}
		}catch (Exception e) {
				e.printStackTrace();
		}finally {
			close();
		}
			
			
		return users;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

	@Override
	public userVO selectUser(userVO vo) {
		String sql = "select * from users where user_id=?";
		try 
		{
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setUser_id(rs.getString("user_id"));
				vo.setUserName(rs.getString("username"));
				vo.setAddress(rs.getString("address"));
				vo.setIs_withRaw(rs.getString("is_withraw"));
				vo;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close();
		}
				
		return null;
	}

	@Override
	public int insertUser(userVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatetUser(userVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(userVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public userVO loginCheck(userVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
