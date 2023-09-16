package com.example.test;

import com.example.test.util.PdfUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

/**
 * @author zlx
 * @date 2023/4/12 15:25
 */
@SpringBootTest
public class UploadTest {
	@Test
	void upload() throws IOException {
		File file = new File("C:\\Users\\zlx\\Downloads\\5.1毕业证.pdf");
		InputStream inputStream = new FileInputStream(file);
		InputStream is = PdfUtil.pdf2Image(inputStream);
		inputStreamToFile(is,new File("C:\\Users\\zlx\\Downloads\\456.png"));
	}
	//获取流文件
	private static void inputStreamToFile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
		}
	}
}
