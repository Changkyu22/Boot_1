package com.iu.b1.member;

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
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberFilesMapper memberFilesMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	
	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check = false;	// true -> error, false -> OK
		
		// annotation 검증 결과
		if(bindingResult.hasErrors()) {
			check = true;
			bindingResult.rejectValue("pw2", "memberVO.pw.notEqual");
			// bindingResult.rejectValue("form의 path명", "출력하고 싶은 properties값의 키");
		}
		
		// pw가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check = true;
		}
		
		// id 중복 검사
		memberVO = memberMapper.memberIdCheck(memberVO);
		
		if(memberVO != null) {
			check = true;
			bindingResult.rejectValue("id", "memberVO.id.notEqual");
		}
		
		return check;
	}
	
	public int memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		// 파일을 저장할 폴더
		
		File file = filePathGenerator.useClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		int result = memberMapper.memberJoin(memberVO);
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		memberFilesMapper.memberFilesInsert(memberFilesVO);
		return result;
	}
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception {
		return memberMapper.memberLogin(memberVO);
	}
	
	public MemberVO memberMypage(MemberVO memberVO)throws Exception{
		return memberMapper.memberMypage(memberVO);
	}
	
	public MemberFilesVO memberFilesSelect(MemberFilesVO memberFilesVO) throws Exception{
		return memberFilesMapper.memberFilesSelect(memberFilesVO);
	}
	

}
