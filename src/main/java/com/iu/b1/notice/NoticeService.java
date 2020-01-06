package com.iu.b1.notice;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
@Transactional
public class NoticeService {
	
	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapprer;
	@Resource(name = "noticeFilesMapper")
	private NoticeFilesMapper noticeFilesMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	
	public int noticeWrite(NoticeVO noticeVO, MultipartFile [] files) throws Exception{
		File file = filePathGenerator.useClassPathResource("notice");
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		int result = noticeMapprer.noticeWrite(noticeVO);
		
//		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		for (int i=1; i<files.length;i++) {
			if(files[i].getOriginalFilename() != "") {
				String fileName = fileSaver.save(file, files[i]);
				noticeFilesVO.setNum(noticeVO.getNum());
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(files[i].getOriginalFilename());
				noticeFilesMapper.noticeFilesWrite(noticeFilesVO);
//				noticeFilesVOs.add(noticeFilesVO);
			}
			
//			noticeFilesMapper.noticeFilesWrite2(noticeFilesVOs);
		}
		return result;
	}

}
