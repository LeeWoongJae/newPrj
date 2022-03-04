package com.mall.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mall.common.DAO;
import com.mall.common.DAOclose;



public class ProductServiceImpl implements ProductService {
	
	Connection conn = DAO.getInstance();
	
	private DAOclose daOclose = new DAOclose();
	private PreparedStatement psmt ; 
	private ResultSet rs;
	
	
	@Override
	public List<ProductVO> productList() {
		List<ProductVO> prodList = new ArrayList<>();
		ProductVO   vo;
		String sql = "select * from products";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ProductVO();
				vo.setPcode(rs.getString("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setImage(rs.getString("image"));
				vo.setMadein(rs.getString("madein"));
				vo.setContent(rs.getString("content"));
				vo.setPrice(rs.getString("price"));
				vo.setInsert_date(rs.getString("insert_date"));
				vo.setPcolor(rs.getString("pcolor"));
				vo.setPsize(rs.getString("psize"));
				vo.setCategory(rs.getString("category"));
				vo.setStock(rs.getString("stock"));
				vo.setIs_popular(rs.getString("is_popular"));
				
				
				prodList.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				daOclose.close(rs, psmt, conn);
				
			}
		
		
		return prodList;
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		String sql = "SELECT * FROM PRODUCTS WHERE PCODE=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPcode());			
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setPcode(rs.getString("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setImage(rs.getString("image"));
				vo.setMadein(rs.getString("madein"));
				vo.setContent(rs.getString("content"));
				vo.setPrice(rs.getString("price"));
				vo.setInsert_date(rs.getString("insert_date"));
				vo.setPcolor(rs.getString("pcolor"));
				vo.setPsize(rs.getString("psize"));
				vo.setCategory(rs.getString("category"));
				vo.setStock(rs.getString("stock"));
				vo.setIs_popular(rs.getString("is_popular"));
			
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}			
		
		return vo;
	}

	@Override
	public int productUpdate(ProductVO vo) {
		String sql = "update products set pname=? , image=? , madein=? , content=? , price=? , category=? , stock=? , is_popular=? where pcode=?";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPname());
			psmt.setString(2, vo.getImage());
			psmt.setString(3, vo.getMadein());
			psmt.setString(4, vo.getContent());
			psmt.setString(5, vo.getPrice());
			psmt.setString(6, vo.getCategory());
			psmt.setString(7, vo.getStock());
			psmt.setString(8, vo.getIs_popular());
			
			psmt.setString(9, vo.getPcode());
			
			
			
			n = psmt.executeUpdate();
					
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		return n;
	}

	@Override
	public int productInsert(ProductVO vo) {
		String sql = "insert into products values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getPcode());
			psmt.setString(2, vo.getPname());
			psmt.setString(3, vo.getImage());
			psmt.setString(4, vo.getMadein());
			psmt.setString(5, vo.getContent());
			psmt.setString(6, vo.getPrice());
			psmt.setString(7, vo.getInsert_date());
			psmt.setString(8, vo.getPcolor());
			psmt.setString(9, vo.getPsize());
			psmt.setString(10, vo.getCategory());
			psmt.setString(11, vo.getDelivery_fee());
			psmt.setString(12, vo.getStock());
			psmt.setString(13, vo.getIs_popular());
			
			
			
			
			r= psmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return r;
	}

	@Override
	public int productDelete(ProductVO vo) {
		String sql = "delete from products where pcode=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPcode());
			n = psmt.executeUpdate();
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		return n;
	}

}
