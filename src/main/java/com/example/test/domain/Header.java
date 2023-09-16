package com.example.test.domain;

import java.io.Serializable;

/**
 * @author zhanglixiang
 * @date 2023/8/6 16:44
 */
public class Header implements Serializable {
	private String serviceCode;
	private String version;
	private String sourceCode;
	private String apiCode;
	private String timestamp;
	private String signature;


	public Header() {
		this.serviceCode = "32000";
		this.version = "1.0";
		this.sourceCode = "3200011AA001";
		this.apiCode = "392-0002";
		this.timestamp = "20200622111020;";
		this.signature = "";

	}

	public Header(String serviceCode, String version, String sourceCode, String apiCode, String timestamp, String signature) {
		this.serviceCode = serviceCode;
		this.version = version;
		this.sourceCode = sourceCode;
		this.apiCode = apiCode;
		this.timestamp = timestamp;
		this.signature = signature;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
