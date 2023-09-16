package com.example.test;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.domain.AA10DTO;
import com.example.test.domain.Menu;
import com.example.test.domain.ParameterRes;
import com.example.test.domain.User;
import com.neusoft.golf.piles.bcp.sdk.util.Client;
import com.neusoft.golf.piles.bcp.sdk.util.ClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zlx
 * @date 2022/5/17 15:41
 */
@SpringBootTest
public class JsonFormatTest {


	private static final Logger LOGGER = LoggerFactory.getLogger(JsonFormatTest.class);

	public static void main(String[] args) throws ParseException {
		String dateString = "2022-09-28 19:13:29";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateTime dateTime = DateUtil.offsetHour(dateFormat.parse(dateString), 48);
		System.out.println("dateTime = " + dateTime);

	}
	@Test
	public void jsonFormat() {
		String body = "{\n" +
				"    \"appcode\": \"0\",\n" +
				"    \"msg\": \"\",\n" +
				"    \"map\": {\n" +
				"        \"data\": [\n" +
				"            {\n" +
				"                \"baz001\": \"202306090650\",\n" +
				"                \"aaa100\": \"ACA112\",\n" +
				"                \"aaa102\": \"11010401\",\n" +
				"                \"aaa103\": \"理论经济学\",\n" +
				"                \"bae024\": \"110104\",\n" +
				"                \"aae100\": \"1\",\n" +
				"                \"aae035\": null\n" +
				"            },\n" +
				"            {\n" +
				"                \"baz001\": \"202306090651\",\n" +
				"                \"aaa100\": \"ACA112\",\n" +
				"                \"aaa102\": \"11010402\",\n" +
				"                \"aaa103\": \"应用经济学\",\n" +
				"                \"bae024\": \"110104\",\n" +
				"                \"aae100\": \"1\",\n" +
				"                \"aae035\": null\n" +
				"            }\n" +
				"        ]\n" +
				"    }\n" +
				"}";
		JSONObject jsonObject = new JSONObject();
//		List<Education> educations = JSONObject.parseArray(body, Education.class);
		ParameterRes parameterRes = JSONObject.parseObject(body, ParameterRes.class);

		Map map = parameterRes.getMap();
		List<AA10DTO> data = JSON.parseArray(map.get("data").toString(), AA10DTO.class);
		AA10DTO aa10DTO = data.get(0);
		System.out.println("aa10DTO = " + aa10DTO);
//		System.out.println("educations = " + educations);
	}

	@Test
	void logger() throws Exception {
//		getImageStr("C:\\Users\\zlx\\Pictures\\微信图片_20210825093826.jpg");
//		String s = StringUtils.leftPad("1000", 4, "0");
		String s = 4 > 0 ? String.format("%0" + Integer.toString(4) + "d", 1000) : Integer.toString(1000);
		String s1 = StringUtils.leftPad("1000", 4, "0");
		System.out.println("s1 = " + s1);
//		System.out.println("format = " + s);

		JSONObject json = new JSONObject();
		json.put("exist",false);
		json.put("seqCode", new JSONArray());
		JSONArray array = new JSONArray();
		int last = 999;
		for (int i = 1; i < last; i++) {
				array.add(i);
		}
	}
	@Test
	public static String getImageStr(String imgFile) {
		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(imgFile);
			data = new byte[inputStream.available()];
			int read = inputStream.read(data);
			// 加密
			if(data !=null) {
				Base64Encoder encode = new Base64Encoder();

				String encode1 = encode.encode(data);
				System.out.println("" + encode1);
				return encode.encode(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream!=null) {
				try{
					inputStream.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	@Test
	private String subStringFilePath(String remoteFilePath) {
		if (remoteFilePath.startsWith("/")) {
			return remoteFilePath.substring(1);
		}
		return remoteFilePath;
	}

	@Test
	void testss() {
		User user =null;
		User user1 = Optional.ofNullable(user).orElse(new User());
		System.out.println("user1 = " + user1);
	}


	@Test
	public void tyzdTest() {
//模拟从数据库查询出来
		List<Menu> menus = Arrays.asList(
				new Menu(1,"根节点",0),
				new Menu(2,"子节点1",1),
				new Menu(3,"子节点1.1",2),
				new Menu(4,"子节点1.2",2),
				new Menu(5,"根节点1.3",2),
				new Menu(6,"根节点2",1),
				new Menu(7,"根节点2.1",6),
				new Menu(8,"根节点2.2",6),
				new Menu(9,"根节点2.2.1",7),
				new Menu(10,"根节点2.2.2",7),
				new Menu(11,"根节点3",1),
				new Menu(12,"根节点3.1",11)
		);

		//获取父节点
		List<Menu> collect = menus.stream().filter(m -> m.getParentId() == 0).map(
				(m) -> {
					m.setChildList(getChildrens(m, menus));
					return m;
				}
		).collect(Collectors.toList());
		System.out.println("collect = " + collect);
		Menu menu = collect.get(0);
		System.out.println("menu = " + menu);
		List<List<Menu>> collect1 = collect.stream()
				.map(a -> {
					return a.getChildList();
				}).collect(Collectors.toList());
		System.out.println("collect1 = " + collect1);

	}
	@Test
	public void jwtSign() {
		String sign = jwtSignFun();
		System.out.println("jwtSign:" + sign);
	}
	private String jwtSignFun() {
		ClientUtil clientUtil = ClientUtil.getSingleton();
		return clientUtil.jwtSign(Client.builder().apiId("399-0010")
				.clientId("6000000061823995").timestamp()
				.build(), "3000002112363467");
	}
//	private String jwtSignFun() {
//		ClientUtil clientUtil = ClientUtil.getSingleton();
//		return clientUtil.jwtSign(Client.builder().apiId("399-0129")
//				.clientId("6000000061823995").timestamp()
//				.build(), "3000002112363467");
//	}
//	private String jwtSignFun() {
//		ClientUtil clientUtil = ClientUtil.getSingleton();
//		return clientUtil.jwtSign(Client.builder().apiId("910-0003")
//				.clientId("2000002100913732").timestamp()
//				.build(), "4000000304016910");
//	}
	/**
	 * 递归查询子节点
	 * @param root  根节点
	 * @param all   所有节点
	 * @return 根节点信息
	 */
	private List<Menu> getChildrens(Menu root, List<Menu> all) {
		List<Menu> children = all.stream().filter(m -> {
			return Objects.equals(m.getParentId(), root.getId());
		}).map(
				(m) -> {
					m.setChildList(getChildrens(m, all));
					return m;
				}
		).collect(Collectors.toList());
		return children;
	}

}
