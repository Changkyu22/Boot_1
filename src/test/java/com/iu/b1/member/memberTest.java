package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class memberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	
	void test() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("ck");
		memberVO.setPw("ck");
		memberVO.setEmail("ck@ck");
		memberVO.setName("ck");
		int result = memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
	}
	
	@Test
	void login() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("ck");
		memberVO.setPw("ck");
		memberVO = memberMapper.memberLogin(memberVO);
		assertNotNull(memberVO);
		
		
	}

}
