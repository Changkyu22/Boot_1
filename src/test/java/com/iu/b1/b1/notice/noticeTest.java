package com.iu.b1.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.notice.NoticeMapper;
import com.iu.b1.notice.NoticeVO;

@SpringBootTest
class noticeTest {
	
	@Autowired
	private NoticeMapper noticeMapper;

	@Test
	public void noticeWrite() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("nuri");
		noticeVO.setWriter("nuri");
		noticeVO.setContents("nulnul");
		int result = noticeMapper.noticeWrite(noticeVO);
		assertEquals(1, result);
	}
}
