package com.example.test.domain;

import java.io.Serializable;

/**
 * @author zhanglixiang
 * @date 2023/8/6 16:42
 */
public class Req implements Serializable {
	private Header header;
	private Body body;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
}

