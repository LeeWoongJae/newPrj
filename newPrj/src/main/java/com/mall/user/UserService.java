package com.mall.user;

import java.util.List;

public interface UserService {

	List<UserVO> selectAllList();
	// 전체조회 용
	UserVO selectUser(UserVO vo);
	// 단건으로 찾아오기
	public int insertUser(UserVO vo);
	// 회원등록
	public int updatetUser(UserVO vo);
	// 회원 정보 수정
	public int deleteUser(UserVO vo);
	// 회원 정보 삭제 or 숨김
	public UserVO loginCheck(UserVO vo);
	// 로그인 체크 
	boolean idCheck(String user_id);
	
}
