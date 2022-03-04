package com.mall.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;

public class DAO {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "prj";
	private static String password = "prj";
	public static Connection conn;
	
	public DAO() {}
	
	public static Connection getInstance() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url , user , password);
		}catch (Exception e) {
			System.out.println("DB connect faild");
		}
		
		return conn;
	}
}
