package com.example.test;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.example.test.domain.PersonInfoResDTO;
import com.example.test.domain.User;
import com.example.test.util.ImgUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author zlx
 * @date 2022/10/24 17:46
 */
@SpringBootTest
public class PersonTest {
	String url = "http://10.78.155.17/api/sicp4-basestore-center/api";
	private String accessToken = "bearer eyJhbGciOiJTTTIiLCJ0eXAiOiJKV1QifQ.eyJsb2dpbl91c2VyIjp7ImxvZ2lud2F5IjoiMSIsImNsaWVudGlkIjpudWxsLCJ1c2VyaWQiOiIyMDIxMDYwNzAwMTAzODg0IiwibG9naW5pZCI6InhueWhfZHpkYSIsInVzZXJuYW1lIjoi6Jma5ouf55So5oi3X-eUteWtkOaho-ahiCIsIm9yZ2lkIjoiMjAyMTAxMDcwMDAyMzg3MSIsIm9yZ25hbWUiOiLomZrmi5_nlKjmiLciLCJwYXJlbnRpZCI6bnVsbCwib3JnZW50ZXJjb2RlIjoiMzI5OTAwMDAwMDAwMDEyNiIsInJlZ2lvbmNvZGUiOiIzMjk5MDAwMDAwMDAiLCJkYXRhYXJlYSI6IjMyOTkwMCIsInVzZXJUeXBlIjoiMyIsImxvZ2luVHlwZSI6IjEiLCJ1c2VySWQiOiIyMDIxMDYwNzAwMTAzODg0IiwiaWRUeXBlIjpudWxsLCJpZE51bWJlciI6InhueWhfZHpkYSIsIm5hbWUiOiLomZrmi5_nlKjmiLdf55S15a2Q5qGj5qGIIiwicGFzc3dvcmQiOiIiLCJwYXNzd29yZENvZGUiOm51bGwsImNlbGxwaG9uZSI6bnVsbCwiZW1haWwiOiJJTklUX1NZU19MT0dJTix5d3NsLHN4Z2wseHp0aHN4LHhzeGh6dCx4c3hoenQyLHl3amIseWJ5dyxiamN4LHp4Ynp3aCIsIm5hdGlvbmFsaXR5IjpudWxsLCJzZXgiOiIxIiwiYXV0aExldmVsIjpudWxsLCJhYWMxMDEiOm51bGwsInBlcnNvblVuaXF1ZUlkIjpudWxsLCJ1c2VyU3RhdGUiOm51bGwsInJlZ2lzdHJhdGlvbkRhdGUiOm51bGwsIm5lZWRJbXByb3ZlUHdkIjoiZmFsc2UiLCJjb21wYW55SWQiOm51bGwsInNvY2lhbENyZWRpdENvZGUiOm51bGwsImNvbXBhbnlOYW1lIjpudWxsLCJhYWIxMDEiOm51bGwsInJvbGVMaXN0IjpudWxsLCJsZWdhbElkVHlwZSI6bnVsbCwibGVnYWxJZE51bWJlciI6bnVsbCwibGVnYWxOYW1lIjpudWxsLCJsZWdhbENlbGxwaG9uZSI6bnVsbCwibGVnYWxFbWFpbCI6bnVsbCwibGVnYWxOYXRpb25hbGl0eSI6bnVsbCwibGVnYWxTZXgiOm51bGwsImxlZ2FsUmVnaXN0cmF0aW9uRGF0ZSI6bnVsbCwibXV0aXBsZUFnZW50c0ZsYWciOm51bGwsImNhU3lzdGVtRmxhZyI6bnVsbCwiY29tcGFueVVzZXJJZCI6bnVsbCwidXNlckxldmVsIjpudWxsLCJhdXRob3JpemF0aW9uU3RhcnREYXRlIjpudWxsLCJhdXRob3JpemF0aW9uRGVhZGxpbmUiOm51bGwsInBvc2l0aW9uSWQiOm51bGwsInBvc2l0aW9uTmFtZSI6bnVsbCwibGFzdExvZ2luRGF0ZSI6bnVsbCwiYmdPcmdMaXN0IjpudWxsLCJiZ01lbnVMaXN0IjpudWxsLCJiZ0Z1bmNMaXN0IjpudWxsLCJzaW1wUHciOm51bGwsInRlbCI6bnVsbCwib3JnUGF0aCI6Iuaxn-iLj-ecgS_nnIHmnKznuqfvvIjnnIHnm7TvvIkv5rGf6IuP55yB5Lq65Yqb6LWE5rqQ5ZKM56S-5Lya5L-d6Zqc5Y6FL-S_oeaBr-S4reW_gy_ljoLllYYv5Lqs5Zu-56eR5oqAL-iZmuaLn-eUqOaItyIsIm9yZ2FuSWQiOm51bGwsIm9yZ2FuVXNlcklkIjpudWxsLCJhYXoxMDAiOm51bGwsIm9yZ2FuTmFtZSI6bnVsbCwib3JnYW5UeXBlIjpudWxsfSwidXNlcl9uYW1lIjoi6Jma5ouf55So5oi3X-eUteWtkOaho-ahiCIsInNjb3BlIjpbIndyaXRlIl0sImV4cCI6MzIxMDgyNDU3NCwiYXV0aG9yaXRpZXMiOlsiLyoqLyoiXSwianRpIjoiZDgzOWIyZmItYjRlZC00NTkyLTlkOWItMmVjZGZjNGI5MjExIiwiY2xpZW50X2lkIjoiMSIsImN1cnJlbnRfdXNlciI6eyJsb2dpbndheSI6IjEiLCJjbGllbnRpZCI6bnVsbCwidXNlcmlkIjoiMjAyMTA2MDcwMDEwMzg4NCIsImxvZ2luaWQiOiJ4bnloX2R6ZGEiLCJ1c2VybmFtZSI6IuiZmuaLn-eUqOaIt1_nlLXlrZDmoaPmoYgiLCJvcmdpZCI6IjIwMjEwMTA3MDAwMjM4NzEiLCJvcmduYW1lIjoi6Jma5ouf55So5oi3IiwicGFyZW50aWQiOm51bGwsIm9yZ2VudGVyY29kZSI6IjMyOTkwMDAwMDAwMDAxMjYiLCJyZWdpb25jb2RlIjoiMzI5OTAwMDAwMDAwIiwiZGF0YWFyZWEiOiIzMjk5MDAifX0.MEQCIBJ3dfV3kYgyJX-R7b2H9FDT7wlISO381zT4LYHaLwhjAiACEwrKAD2P2nWpeOtPTEcOoM7yXIEwBNqulwyIOiBrhA";
	@Test
	public void getPersonInfo() {
		Map map = new HashMap();
		map.put("certificateNumber", "342224199811151316");

//		HttpRequest request = new HttpRequest(url+"/personInfoQueryApi/queryPersonInfo");
//		request.header("Authorization", accessToken);
		String post = HttpRequest.post(url + "/personInfoQueryApi/queryPersonInfo").body(JSONObject.toJSONString(map))
				.header("Authorization",accessToken)
				.execute().body();
		PersonInfoResDTO personInfoResDTO = JSONObject.parseObject(post, PersonInfoResDTO.class);
		System.out.println("post = " + post);
	}


	@Test
	void function() {
		List<User> list = new ArrayList<>();
		list.add(new User());
		if (!Optional.ofNullable(list.get(0).getAddress()).isPresent()) {
			System.out.println("list = " + list);
		}
	}

	@Test
	void ImgTest() throws IOException {
		File file = new File("C:\\Users\\zlx\\Pictures\\QQ图片20210818101155.png");
		BufferedImage bufferedImage = ImageIO.read(file);
		int width1 = bufferedImage.getWidth();
		int height1 = bufferedImage.getHeight();
		System.out.println("height1 = " + height1);
		System.out.println("width1 = " + width1);
		ImgUtil imgUtil = new ImgUtil(file);
		int width = imgUtil.getWidth();
		int height = imgUtil.getHeight();
		String mimeType = imgUtil.getMimeType();
		System.out.println("width = " + width);
		System.out.println("height = " + height);
		System.out.println("mimeType = " + mimeType);
	}
}
