package net.ash.shopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "/home/anshul/git/Store/shopping/src/main/webapp/assets/images/";
	private static String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest req, MultipartFile file, String code) {
		REAL_PATH = req.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		
		/*to make sure all directories exists
		and create new directories*/
		
		if(!new File("ABS_PATH").exists()) {
			/*create the directories*/
			new File("ABS_PATH").mkdirs();
		}
		if(!new File("REAL_PATH").exists()) {
			/*create the directories*/
			new File("REAL_PATH").mkdirs();
		}
		
		
		try {
			/*server upload*/
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			/*project upload*/
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
}
