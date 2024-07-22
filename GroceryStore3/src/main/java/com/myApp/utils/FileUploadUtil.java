package com.myApp.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	 public static String saveFile(MultipartFile photo) throws IOException {
		 
		 String uploadDirectory = "C:\\Users\\PRAVEEN\\eclipse-workspace\\GroceryStore3\\src\\main\\webapp\\resources\\static\\images\\";

	     File uploadDir = new File(uploadDirectory);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	        String filename = "groc" + photo.getOriginalFilename();
	        String path = uploadDirectory + "\\"+ filename;
	        File saveFile = new File(uploadDirectory, filename);
	        photo.transferTo(saveFile);
	        return "/resources/static/images/" + filename;
	 }
}
