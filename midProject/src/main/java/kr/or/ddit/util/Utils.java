package kr.or.ddit.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class Utils {
	public static byte[] imageToByteArray (String filePath) throws Exception {
		byte[] returnValue = null;
		
		ByteArrayOutputStream bos = null;
		FileInputStream fis = null;
		
		try {
			bos = new ByteArrayOutputStream();
			fis = new FileInputStream(filePath);
			
			byte[] buf = new byte[1024];
			int read = 0;
			
			while((read=fis.read(buf,0,buf.length))!= -1) {
				bos.write(buf,0,read);
			}
			
			returnValue = bos.toByteArray();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bos != null) {bos.close();}
			if(fis != null) {fis.close();}
		}
		
		return returnValue;
	}
}
