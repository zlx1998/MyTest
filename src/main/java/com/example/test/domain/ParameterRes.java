package com.example.test.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * 参数中心返回
 * @author zhanglixiang
 * @date 2023/8/31 17:54
 */
public class ParameterRes implements Serializable {
	private static final long serialVersionUID = -5517062298816857954L;
	/**
	 * 结果标志	0 成功 1 失败
	 */
	private String appcode;

	/**
	 * 失败原因
	 */
	private String msg;

	private Map map;

	public String getAppcode() {
		return appcode;
	}

	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "ParameterRes{" +
				"appcode='" + appcode + '\'' +
				", msg='" + msg + '\'' +
				", map=" + map +
				'}';
	}
}
