package com.mall.orderDetail;

import java.util.List;

public interface OrderDetailService {
	// selectAll
	List<OrderDetailVO> orderDetailList();
	// select
	OrderDetailVO orderDetailSelect();
	// update
	int orderDetailUpdate();
	// isnert
	int orderDetailInsert();
	// delete
	int orderDetailDelete();
}
