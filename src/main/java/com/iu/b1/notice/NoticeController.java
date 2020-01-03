package com.iu.b1.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeWrite")
	public void noticeWrite()throws Exception{
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeWrite(noticeVO);
		String message = "실패다....";
		String path = "../";
		if(result > 0) {
			message = "성공이다^^";
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		
		return mv;
	}
	
}
