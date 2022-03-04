package com.mall.user;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mall.common.DAO;
import com.mall.common.DAOclose;



public class UserServiceImpl implements UserService {
		private DAOclose daOclose = new DAOclose();
		Connection conn = DAO.getInstance();
		private PreparedStatement psmt ; 
		private ResultSet rs;

	


	@Override
	public List<userVO> selectAllList() {
		List<userVO> users = new ArrayList();
		userVO vo;
		String sql = "select * from users";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
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
			daOclose.close(rs,psmt,conn);
		}
			
			
		return users;
	}

//	private void close() {
//		try {
//			if (rs != null)
//				rs.close();
//			if (pstmt != null)
//				pstmt.close();
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
		

	@Override
	public userVO selectUser(userVO vo) {
		String sql = "select * from users where user_id=?";
		try 
		{
			psmt  = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUser_id());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setUser_id(rs.getString("user_id"));
				vo.setUserName(rs.getString("username"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));;
				vo.setIs_withRaw(rs.getString("is_withraw"));
				vo.setAuthor(rs.getString("author"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			daOclose.close(rs, psmt, conn);
		}
				
		return vo;
	}

	@Override
	public int insertUser(userVO vo) {
		
		String sql = "insert into users values(?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUser_id());
			psmt.setString(2, vo.getPwd());
			psmt.setString(3, vo.getTel());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getIs_withRaw());
			psmt.setString(6, vo.getAuthor());
			psmt.setString(7, vo.getRegDate());
			psmt.setString(8, vo.getUserName());
			
			r = psmt.executeUpdate();
			System.out.println(r + "건이 등록");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}

		
		return r;
	}

	@Override
	public int updatetUser(userVO vo) {
				String sql = "update users set pwd= ? , address=? , tel = ? where user_id=?";
				int n = 0;
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getPwd());
					psmt.setString(2, vo.getAddress());
					psmt.setString(3, vo.getTel());
					psmt.setString(4, vo.getUser_id());
					
					
					n = psmt.executeUpdate();
							
				}catch (Exception e) {
						e.printStackTrace();
				}finally {
					daOclose.close(rs, psmt, conn);
				}
		return n;
	}

	@Override
	public int deleteUser(userVO vo) {
		String sql = "delete from users where user_id=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUser_id());
			
			n = psmt.executeUpdate();
					
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		finally {
			daOclose.close(rs, psmt, conn);
		}
	return n;
	}
	@Override
	public userVO loginCheck(userVO vo) {
		String sql = "select * from users where user_id=? and pwd=?";
		try 
		{
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, vo.getUser_id());
			psmt.setString(2, vo.getPwd());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setUserName(rs.getString("username"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		return vo;
	}
	public boolean idCheck(String user_id) {
		boolean isId = false;
		String sql = "select user_id from users where user_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				isId = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
				
		return isId;
	}

}
