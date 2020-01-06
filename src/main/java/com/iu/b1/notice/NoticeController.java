package com.iu.b1.notice;

import java.util.List;

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

import com.iu.b1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO = noticeService.noticeSelect(noticeVO);
		mv.addObject("vo", noticeVO);
		mv.setViewName("notice/noticeSelect");
		
		return mv;
	}
	
	
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> ar = noticeService.noticeList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("notice/noticeList");
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public String noticeWrite()throws Exception{
		return "notice/noticeWrite";
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile [] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			System.out.println("여기 오면 안돼11111");
			mv.addObject("noticeVO", noticeVO);
			System.out.println("여기 오면 안돼22222");
			mv.setViewName("notice/noticeWrite");
			System.out.println("여기 오면 안돼333333");
		}else {
			int result = noticeService.noticeWrite(noticeVO, files);
			String message = "실패다....";
			String path = "../";
			System.out.println("여기 와야해^^");
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
