package com.iu.b1.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NoticeFilesMapper {
	
	public int noticeFilesWrite(NoticeFilesVO noticeFilesVO)throws Exception; 
	
	public int noticeFilesWrite2(List<NoticeFilesVO> noticeFilesVOs)throws Exception;

}
