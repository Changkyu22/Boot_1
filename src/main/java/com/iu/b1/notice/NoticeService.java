package com.iu.b1.notice;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapprer;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	
	public int noticeWrite(NoticeVO noticeVO) throws Exception{
		return noticeMapprer.noticeWrite(noticeVO);
	}

}
