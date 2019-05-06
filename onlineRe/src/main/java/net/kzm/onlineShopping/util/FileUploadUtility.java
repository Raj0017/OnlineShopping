package net.kzm.onlineShopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	
	private static final String ABS_PATH="C:\\Users\\Raj\\git\\flash\\onlineRe\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH="";
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		//first get the real path
		
	REAL_PATH=request.getSession().getServletContext().getRealPath("/assest/images/");
	
	       if(!new File(ABS_PATH).exists())
	        {
		       new File(ABS_PATH).mkdirs();
	              }
		
	if(!new File(REAL_PATH).exists())
		{
			new File(REAL_PATH).mkdirs();
		}
		
	try {
		//for server Upload
		file.transferTo(new File(REAL_PATH+code+".jpg"));
		
		//project directive upload
		file.transferTo(new File(ABS_PATH+code+".jpg"));
		
	}catch(IOException ex)
	{
		
	}
		
		
	}

}
