package com.iu.b1.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.notice.NoticeMapper;
import com.iu.b1.notice.NoticeVO;

@SpringBootTest
class BoardWriteTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void test() throws Exception{
		for(int i=0; i<30; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("nuri"+i);
			noticeVO.setWriter("nuri"+i);
			noticeVO.setContents("contetns"+i);
			noticeMapper.noticeWrite(noticeVO);
		}
	}

}
