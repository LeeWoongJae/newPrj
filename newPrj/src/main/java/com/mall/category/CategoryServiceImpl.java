package com.mall.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public CategoryVO select(CategoryVO vo) {
		// TODO Auto-generated method stub		
		String sql = "select fcName, scName, tcname from category where UPPER(NVL(fc, 'NULL')) = UPPER(?) and UPPER(NVL(sc, 'NULL')) = UPPER(?) and UPPER(NVL(tc, 'NULL')) = UPPER(?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFc());
			psmt.setString(2, vo.getSc());
			psmt.setString(3, vo.getTc());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo.setFcName(rs.getString("fcname"));
				vo.setScName(rs.getString("scname"));
				vo.setTcName(rs.getString("tcname"));				
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
	public int insert(CategoryVO vo) {
		
		String sql = "insert into category values(?,?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFc());
			psmt.setString(2, vo.getFcName());
			psmt.setString(3, vo.getSc());
			psmt.setString(4, vo.getScName());
			psmt.setString(5, vo.getTc());
			psmt.setString(6, vo.getTcName());
			
			n = psmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
				
		
		
		
		
		return n;
	}

	@Override
	public int update(CategoryVO vo) {
			String sql = "update category set fc=?, sc=?, tc=? where fc=?";
			int n = 0;
			try {
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, vo.getFc());
				psmt.setString(2, vo.getSc());
				psmt.setString(3, vo.getTc());
				psmt.setString(4, vo.getFc());
				
				n = psmt.executeUpdate();
						
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				daOclose.close(rs, psmt, conn);
			}
		return n;
	}

	@Override
	public int delete(CategoryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<CategoryVO> cateFcList() {
		List<CategoryVO> cateFcList = new ArrayList<>();
		CategoryVO vo;
		String sql = "select distinct(NVL(fcname , ' ')) fcName from category";
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new CategoryVO();
				vo.setFcName(rs.getString("fcname"));
				cateFcList.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				daOclose.close(rs, psmt, conn);
				
			}		
		
		return cateFcList;
	}

	@Override
	public List<CategoryVO> cateScList(String cateFc) {
		List<CategoryVO> cateScList = new ArrayList<>();
		CategoryVO vo;
		String sql = "select distinct(NVL(scName , ' ')) scName from category where fc =?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, cateFc);			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new CategoryVO();
				
				//vo.setSc(rs.getString("sc"));
				vo.setScName(rs.getString("scName"));
				cateScList.add(vo);	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				daOclose.close(rs, psmt, conn);
				
			}		
		
		return cateScList;
	}

	@Override
	public List<CategoryVO> cateTcList(String cateFc , String cateSc) {
		List<CategoryVO> cateTcList = new ArrayList<>();
		CategoryVO vo;
		String sql = "select distinct(NVL(tcName,' ')) tcName from category where fc = ? and sc = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, cateFc);
			psmt.setString(2, cateSc);
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new CategoryVO();
				//vo.setTc(rs.getString("tc"));
				vo.setTcName(rs.getString("tcName"));
				cateTcList.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				daOclose.close(rs, psmt, conn);
				
			}		
		
		return cateTcList;
	}
	
	

}
