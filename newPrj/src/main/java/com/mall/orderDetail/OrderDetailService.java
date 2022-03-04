package com.mall.orderDetail;

import java.util.List;

public interface OrderDetailService {
	// selectAll
	List<OrderDetailVO> orderDetailList();
	// select
	OrderDetailVO orderDetailSelect(OrderDetailVO vo);
	// update
	public int orderDetailUpdate(OrderDetailVO vo);
	// isnert
	public int orderDetailInsert(OrderDetailVO vo);
	// delete
	public int orderDetailDelete(OrderDetailVO vo);
}
