package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileUtility {
	
	public static String saveFile(MultipartFile file, String filePath) {
		try {
			if(file.getSize() > 0) {
				String pathUrl = filePath + "/" + fileNameMake(file);
				file.transferTo(new File(pathUrl));
				return pathUrl;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} 
		return null;
	}
	
	public static String fileNameMake(MultipartFile file) {
		Date date = new Date();
		SimpleDateFormat formatToday = new SimpleDateFormat("yyMMdd");
		String today = formatToday.format(date);
		int ranNum = (int)Math.floor(Math.random()*(Integer.valueOf(today)));
		String fileName = today+ranNum+"."+file.getContentType().split("/")[1];
		
		return fileName;
	}
	
	public static boolean deleteFile(List<Map<String,String>> filePath) {
		try {
			for(int a = 0 ; a < filePath.size(); a++) {
				for(int b = 1 ; b <= 3 ; b++) {
					if(filePath.get(a).get("product_image"+b) != null) {
						File file = new File(filePath.get(a).get("product_image"+b));
						file.delete();
					}
				}
			}
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
