package com.mall.notice;

public class NoticeVO {
	private String noticeNo;
	private String userId;
	private String noticeTitle;
	private String noticeContent;
	
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", userId=" + userId + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + "]";
	}
	
	
}
