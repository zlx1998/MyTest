package com.example.test.domain;

import java.util.List;

/**
 * @author zhanglixiang
 * @date 2023/9/4 11:39
 */
public class ParameterData {
	private List<AA10DTO> data;
	private String timestamp;

	public List<AA10DTO> getData() {
		return data;
	}

	public void setData(List<AA10DTO> data) {
		this.data = data;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
