package com.mall.orderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mall.common.DAO;
import com.mall.common.DAOclose;

public class OrderDetailServiceImpl  implements OrderDetailService {
	private DAOclose daOclose = new DAOclose();
	Connection conn = DAO.getInstance();
	PreparedStatement psmt ; 
	ResultSet rs;
	
	
	@Override
	public List<OrderDetailVO> orderDetailList() {
		List<OrderDetailVO> list = new ArrayList();
		
		OrderDetailVO vo;
		String sql = "select * from order_detail";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new OrderDetailVO();
				vo.setOrderNo(rs.getString("order_no"));
				vo.setOrderStatus(rs.getString("order_status"));
				vo.setoPname(rs.getString("o_pname"));
				vo.setoColor(rs.getString("o_color"));
				vo.setoSize(rs.getString("o_size"));
				vo.setoCnt(rs.getString("o_pcnt"));
				vo.setoPrice(rs.getString("o_price"));
				vo.setoDate(rs.getString("o_date"));
				vo.setpCode(rs.getString("pcode"));
				
				
				list.add(vo);
			}
		
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return list;
	}

	@Override
	public OrderDetailVO orderDetailSelect(OrderDetailVO vo) {
			String sql = "select * from order_detail where order_no=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, rs.getString("order_no"));
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					
					vo.setOrderStatus(rs.getString("order_status"));
					vo.setoPname(rs.getString("o_pname"));
					vo.setoColor(rs.getString("o_color"));
					vo.setoSize(rs.getString("o_size"));
					vo.setoCnt(rs.getString("o_pcnt"));
					vo.setoPrice(rs.getString("o_price"));
					vo.setoDate(rs.getString("o_date"));
					vo.setpCode(rs.getString("pcode"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				daOclose.close(rs, psmt, conn);
			}
		return vo;
	}

	@Override
	public int orderDetailUpdate(OrderDetailVO vo) {
		String sql ="update oder_detail set(?,?,?,?,?,?,?) where order_no=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getOrderStatus());
			psmt.setString(2, vo.getoPname());
			psmt.setString(3, vo.getoColor());
			psmt.setString(4, vo.getoSize());
			//psmt.setString(5, vo.);
			psmt.setString(5, vo.getoPrice());
			psmt.setString(6, vo.getoDate());
			psmt.setString(7, vo.getpCode());
			
			
			psmt.setString(8, vo.getOrderNo());
			
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return n;
	}

	@Override
	public int orderDetailInsert(OrderDetailVO vo) {
		String sql ="insert into order_detail values(order_detail_seq_no.NEXTVAL,?,?,?,?,?,?, SYSDATE,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getOrderStatus());
			psmt.setString(2, vo.getoPname());
			psmt.setString(3, vo.getoColor());
			psmt.setString(4, vo.getoSize());
			psmt.setString(5, vo.getoCnt());
			psmt.setString(6, vo.getoPrice());
			// psmt.setString(6, vo.getoDate());
			psmt.setString(7, vo.getpCode());
			
			r = psmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daOclose.close(rs, psmt, conn);
		}
		
		return r;
	}

	@Override
	public int orderDetailDelete(OrderDetailVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
