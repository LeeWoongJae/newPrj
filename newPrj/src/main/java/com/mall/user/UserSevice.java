package com.mall.user;

import java.util.List;

public interface UserSevice {

	List<userVO> selectAllList();
	// 전체조회 용
	userVO selectUser(userVO vo);
	// 단건으로 찾아오기
	public int insertUser(userVO vo);
	// 회원등록
	public int updatetUser(userVO vo);
	// 회원 정보 수정
	public int deleteUser(userVO vo);
	// 회원 정보 삭제 or 숨김
	public userVO loginCheck(userVO vo);
	// 로그인 체크 
	
}
