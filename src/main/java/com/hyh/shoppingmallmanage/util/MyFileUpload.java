package com.hyh.shoppingmallmanage.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public class MyFileUpload {

	static HttpServletRequest request;

	public static List<String> newFileName(MultipartFile[] files) {
		List<String> newFileNames = new ArrayList<String>();
		String fileName,newFileName = null;
		for(int i=0;i<files.length;i++) {
			if(!files[i].isEmpty()) {
				fileName = files[i].getOriginalFilename();
				newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
				newFileNames.add(newFileName);
			}	
		}
		return newFileNames;
	}
	public static String newFileName(MultipartFile file) {
		String fileName,newFileName = null;
		fileName = file.getOriginalFilename();
		newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
		return newFileName;
	}

	public static void upload(MultipartFile file,String fileName) {
		String filePath = "D:/IntelliJIDEAProjects/shoppingmall-manage/src/main/resources/static/upload/image";
		System.out.println(filePath);
		File newFile = new File(filePath+"/"+fileName);
		try {
			file.transferTo(newFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void upload(MultipartFile[] files,List<String> fileNames) {
		String fileName,filePath = null;
		File file = null;
		for(int i=0;i<files.length;i++) {
			if(files[i]!=null && "".equals(files[i])) {
				fileName = fileNames.get(i);
				filePath = "D:/IntelliJIDEAProjects/shoppingmall-manage/src/main/resources/static/upload/image";
				file = new File(filePath+"/"+fileName);
				try {
					files[i].transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}	
		}	
	}
}
