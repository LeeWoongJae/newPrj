package com.mall.review;

import java.util.List;

public interface ReviewService {
	// selectAll
	List<ReviewVO> reviewList();
	// select
	ReviewVO reviewSelect(ReviewVO vo);
	// update
	int reviewUpdate(ReviewVO vo);
	// insert
	int reviewInsert(ReviewVO vo);
	// delete
	int reviewDelete(ReviewVO vo);
}
