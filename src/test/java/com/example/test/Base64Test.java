package com.example.test;

import cn.hutool.core.codec.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author zlx
 * @date 2022/12/6 18:10
 */
@SpringBootTest
public class Base64Test {
	@Test
	void test() throws FileNotFoundException {
		File file = new File("E:\\桌面\\兴智板块.pdf");
		String encode = Base64.encode(file);
		System.out.println("encode = " + encode);
	}

	@Test
	void fomat() {
		String s = "RS01,";
		s = s.substring(0, s.length() - 1);
		System.out.println("s = " + s);
	}
}
