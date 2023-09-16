package com.example.test;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.example.test.domain.Body;
import com.example.test.domain.Header;
import com.example.test.domain.Req;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author zhanglixiang
 * @date 2023/6/2 17:16
 */
@Slf4j
@SpringBootTest
public class StrTest {

	private static final String EXT="pdf,jpg,png";
	@Test
	public void strTest() {
		String ex = "Pdf";
//		String ex = "pdg";

		System.out.println("ex = " + ex.toLowerCase());
	}

	@Test
	void urlTest() {
		LocalDateTime startTime = LocalDateTime.now(); // 记录开始时间
		Req req = new Req();
		Body body =new Body("RS072900007674293099");
		Header header = new Header();
		req.setHeader(header);
		req.setBody(body);
		String s = JSONObject.toJSONString(req);

		HttpResponse post = HttpRequest.post("http://dzzzjk.app.jshrss:10011/dzzzinte/jtCommon/archive/system"
		).body(s).setHttpProxy("127.0.0.1", 7890).execute();
		LocalDateTime endTime = LocalDateTime.now(); //记录结束时间
		long durationInSeconds = java.time.Duration.between(startTime, endTime).getSeconds();
		System.out.println("持续时间（秒）：" + durationInSeconds);
		System.out.println("s = " + s);
	}
}
