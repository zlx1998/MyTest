package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglixiang
 * @date 2023/8/9 14:54
 */
@RestController
@RequestMapping("dialTest")
public class DialTestController {
	@GetMapping
	public void test(HttpServletRequest httpServletRequest) {
		Map<String, String> parameterMap = new HashMap<>();
		Enumeration parameterNames = httpServletRequest.getHeaderNames();
		while (parameterNames.hasMoreElements()) {
			String name = (String) parameterNames.nextElement();
			String val = httpServletRequest.getHeader(name);
			parameterMap.put(name, val);
		}
		parameterMap.forEach((key, value) -> System.out.println(key + "-------" + value));
		System.out.println("parameterNames = " +parameterMap.toString());
	}
}
