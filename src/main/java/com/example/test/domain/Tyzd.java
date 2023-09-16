package com.example.test.domain;

/**
 * @author zlx
 * @date 2022/5/25 15:41
 */
public enum Tyzd {
	/**
	 * 成功
	 */
	SUCCESS("bjmc"),

	/**
	 * 失败
	 */
	FAIL("fail"),
	;
	private String name;

	Tyzd(String name) {
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
