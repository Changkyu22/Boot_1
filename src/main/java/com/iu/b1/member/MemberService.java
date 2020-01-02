package com.iu.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	public int memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		// 파일을 저장할 폴더
		
		File file = filePathGenerator.useClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		
		return 0; //memberMapper.memberJoin(memberVO);
	}

}
