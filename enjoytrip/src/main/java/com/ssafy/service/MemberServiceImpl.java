package com.ssafy.service;


import com.ssafy.mapper.MemberMapper;
import com.ssafy.vo.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final SqlSession sqlSession;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Member login(Member member) throws Exception {
		if (member.getId() == null || member.getPass() == null)
			return null;
		Member retMember = sqlSession.getMapper(MemberMapper.class).login(member);
		if (passwordEncoder.matches(member.getPass(), retMember.getPass())){
			retMember.setPass(null);
			return retMember;
		}
		else
			return null;

	}

	@Override
	public Member userInfo(String userid) throws Exception {
		Member member = sqlSession.getMapper(MemberMapper.class).userInfo(userid);
		System.out.println(member.getAddress());
		return member;
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userid);
		map.put("token", refreshToken);
		sqlSession.getMapper(MemberMapper.class).saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		sqlSession.getMapper(MemberMapper.class).deleteRefreshToken(map);
	}

	@Override
	public int insert(Member member) throws Exception {
		member.setPass(passwordEncoder.encode(member.getPass()));
		return sqlSession.getMapper(MemberMapper.class).insert(member);
	}

	@Override
	public int update(Member member) throws Exception {
		member.setPass(passwordEncoder.encode(member.getPass()));
		return sqlSession.getMapper(MemberMapper.class).update(member);
	}

	@Override
	public int delete(String id) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).delete(id);
	}

	@Override
	public boolean dupCheck(String id) throws Exception {
		String res = sqlSession.getMapper(MemberMapper.class).dupCheck(id);
		if (res == null)
			return true;
		return false;
	}

}
