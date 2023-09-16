package com.example.test;

import com.example.test.domain.Education;
import com.example.test.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlx
 * @date 2022/8/25 16:16
 */
@SpringBootTest
public class RedisTest {


	/**
	 * 基础库接口地址
	 */
	@Value("${jck.url:http://portal.jshrss/}")
	private String url;
	/**
	 * 基础库个人信息查询接口路径
	 */
	@Value("${jck.personRoute:personInfoManageApi/executeModifyPersonInfoPubBusi}")
	private String personInfoChangeRoute;

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Test
	public void set() {
		SetOperations<Object, Object> opsList = redisTemplate.opsForSet();
		ArrayList<Object> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			User user = new User();
			user.setId(i);
			user.setUsername("张理想" + i);
			user.setAddress("南京" + i);
			list.add(user);
		}
		opsList.add("key1", list.toArray());
	}

	@Test
	public void get12() {
		String ss = "1";
		System.out.println("ss.contains(\"1,2\") = ");

	}

	@Test
	public void get() {
		for (int i = 0; i < 10; i++) {
			List<Object> key1 = redisTemplate.opsForSet().randomMembers("key1", 20);
			if (key1.isEmpty()) {
				set();
			}
			for (Object o : key1) {
				System.out.println("o = " + o);
				redisTemplate.opsForList().remove("key1", 0, o);
			}
		}
	}

	@Test
	public void get1() {
		List<Education> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Education e= new Education();
			e.setXm("张三_" + i);
			e.setZjhm("" + i);
			list.add(e);
		}
		boolean ss = list.stream().anyMatch(s -> s.getXm().equals("张三_2"));
		System.out.println("ss = " + ss);


	}

//	@Resource
//	RedissonClient redissonClient;
//	@Test
//	void redisson() {
//		RLock rLock = redissonClient.getLock("123");
//		rLock.lock(1, TimeUnit.MINUTES);
//		System.out.println("rLock = 121212");
//		if (rLock.isLocked() && rLock.isHeldByCurrentThread()) {
//			rLock.unlock();
//		}
//	}
}
