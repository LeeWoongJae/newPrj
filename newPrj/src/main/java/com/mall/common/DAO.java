package com.mall.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;

public class DAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "prj";
	private String password = "prj";
	public Connection conn;
	
	
	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url , user , password);
		}catch (Exception e) {
			System.out.println("DB connect faild");
		}
	}
}
