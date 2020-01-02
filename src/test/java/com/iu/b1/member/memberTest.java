package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class memberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoinTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("nuri2");
		memberVO.setPw("nuri2");
		memberVO.setEmail("nuri2@nuri");
		memberVO.setName("nuri2");
		int result = memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
		
	}

}
