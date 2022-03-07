package com.mall.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mall.common.DAO;
import com.mall.common.DAOclose;

public class CategoryServiceImpl implements CategoryService {
	private DAOclose daOclose = new DAOclose();
	private Connection conn = DAO.getInstance();
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public int countAll() {
		int n = 0;
		String sql = "SELECT COUNT(FC) FROM CATEGORY";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println( rs.getInt(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return n;		
	}
	
	@Override
	public List<CategoryVO> selectAll() {
		// TODO Auto-generated method stub
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO vo;
		
		String sql = "SELECT * FROM CATEGORY";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new CategoryVO();
				vo.setFc(rs.getString("fc"));
				vo.setFcName(rs.getString("fcname"));
				vo.setSc(rs.getString("sc"));
				vo.setScName(rs.getString("scname"));
				vo.setTc(rs.getString("tc"));
				vo.setTcName(rs.getString("tcname"));
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
	public CategoryVO select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CategoryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CategoryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CategoryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
