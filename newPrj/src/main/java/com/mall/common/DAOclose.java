package com.mall.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOclose {	
	public DAOclose() {
		// TODO Auto-generated constructor stub
	}
	
	public void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		// Connection close
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
