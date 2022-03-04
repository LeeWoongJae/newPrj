package com.mall.notice;

import java.util.List;

public interface NoticeService {
	// selectAll
	List<NoticeVO> noticeList();
	// select
	NoticeVO noticeSelect(NoticeVO vo);
	// update
	int noticeUpdate(NoticeVO vo);
	// insert
	int noticeInsert(NoticeVO vo);
	// delete
	int noticeDelete(NoticeVO vo);
	
}
