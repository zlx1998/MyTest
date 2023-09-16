package com.example.test.domain;

import lombok.Data;

/**
 * @author zlx
 * @date 2022/5/18 22:04
 */
@Data
public class User {
	private Integer id;
	private String username;
	private String address;


	public String sayHello(Integer age) {
		return "hello " + username + ";age=" + age;
	}
	public String sayHello() {
		return "hello " + username;
	}
}
