package com.iu.b1.robot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.head.Header;

@SpringBootTest
class ArmTest {

	@Autowired
	private Header header;
	
	@Resource(name="rightArm")
	private RightArm rightArm;
		
	
	@Test
	void test() {
		assertNotNull(header);
	}

}
