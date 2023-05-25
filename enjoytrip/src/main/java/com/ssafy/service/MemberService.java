package com.ssafy.service;


import com.ssafy.vo.Member;

public interface MemberService {

	public Member login(Member member) throws Exception;
	public Member userInfo(String userid) throws Exception;
	public void saveRefreshToken(String userid, String refreshToken) throws Exception;
	public Object getRefreshToken(String userid) throws Exception;
	public void deleRefreshToken(String userid) throws Exception;

	public int insert(Member member) throws Exception;
	public int update(Member member) throws Exception;
	public int delete(String id) throws Exception;
	public boolean dupCheck(String id) throws Exception;
	
}
