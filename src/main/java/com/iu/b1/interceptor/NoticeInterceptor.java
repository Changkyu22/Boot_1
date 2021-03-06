package com.iu.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.b1.member.MemberVO;

@Component
public class NoticeInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		if(memberVO != null) {
			if(memberVO.getId().equals("admin")) {
				return true;
			}else {
				response.sendRedirect("../");
				return false;
			}
		}
		response.sendRedirect("../");
		return false;
	}
}
