package com.iu.b1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public String memberJoin(MemberVO memberVO) throws Exception{
		return "member/memberJoin";
	}
}
