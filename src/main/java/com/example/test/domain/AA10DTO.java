package com.example.test.domain;

/**
 * @author zhanglixiang
 * @date 2023/8/31 18:41
 */
public class AA10DTO {
	/**
	 * 代码类型
	 */
	private String aaa100;
	/**
	 * 代码值
	 */
	private String aaa102;
	/**
	 * 代码类型说明
	 */
	private String aaa101;
	/**
	 * 代码值释义
	 */
	private String aaa103;
	/**
	 * 有效标志
	 */
	private String aae100;
	/**
	 * 失效时间
	 */
	private String aae035;

	public String getAaa100() {
		return aaa100;
	}

	public void setAaa100(String aaa100) {
		this.aaa100 = aaa100;
	}

	public String getAaa102() {
		return aaa102;
	}

	public void setAaa102(String aaa102) {
		this.aaa102 = aaa102;
	}

	public String getAaa101() {
		return aaa101;
	}

	public void setAaa101(String aaa101) {
		this.aaa101 = aaa101;
	}

	public String getAaa103() {
		return aaa103;
	}

	public void setAaa103(String aaa103) {
		this.aaa103 = aaa103;
	}

	public String getAae100() {
		return aae100;
	}

	public void setAae100(String aae100) {
		this.aae100 = aae100;
	}

	public String getAae035() {
		return aae035;
	}

	public void setAae035(String aae035) {
		this.aae035 = aae035;
	}

	@Override
	public String toString() {
		return "AA10DTO{" +
				"aaa100='" + aaa100 + '\'' +
				", aaa102='" + aaa102 + '\'' +
				", aaa101='" + aaa101 + '\'' +
				", aaa103='" + aaa103 + '\'' +
				", aae100='" + aae100 + '\'' +
				", aae035='" + aae035 + '\'' +
				'}';
	}
}
