package com.iu.b1.notice;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
	}
	
	@GetMapping("noticeWrite")
	public String noticeWrite()throws Exception{
		return "notice/noticeWrite";
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile [] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mv.addObject("noticeVO", noticeVO);
			mv.setViewName("notice/noticeWrite");
		}else {
			int result = noticeService.noticeWrite(noticeVO, files);
			String message = "실패다....";
			String path = "../";
			if(result > 0) {
				message = "성공이다^^";
			}
			mv.setViewName("common/result");
			mv.addObject("message", message);
			mv.addObject("path", path);
		}	
		return mv;
	}
	
}
