package com.iu.b1.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NoticeMapper {
	
	public int noticeWrite(NoticeVO noticeVO)throws Exception;
}
