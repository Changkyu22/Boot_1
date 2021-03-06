package com.iu.b1.util;


import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	public File useClassPathResource(String filePath) throws Exception{
		// classpath 경로를 받아오기 위해 사용
		// 시작경로의 classpath 구문은 생략
		// 나머지는 ResourceLoader와 같음
		
		String path = "/static/"; 
		ClassPathResource classPathResource = new ClassPathResource(path);
		File file = new File(classPathResource.getFile(), filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		System.out.println(file.getAbsolutePath());
		return file;
	}
	
	
	public File useResourceLoader(String filePath) throws Exception{
		String path = "classpath:/static/";
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
								// classes:/static						, upload
		// ResourceLoader는 classPath 경로를 받아오기 위해 사용
		// 생성하려는 폴더가 없으면 에러 발생
		// static 경로를 이용해서 File 객체를 생성하고, 하위폴더(Child)를 상용해서 폴더 생성
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		System.out.println(file.getAbsolutePath());
		
		return file;
	}
	
	public File useServletContext(String filePath) {
		String files = servletContext.getRealPath("upload");
		File file = new File(files);
		if(!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

}
