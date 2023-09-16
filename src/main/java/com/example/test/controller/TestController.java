package com.example.test.controller;

import com.example.test.service.RedisUtils;
import com.example.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zlx
 * @date 2022/7/19 10:30
 */
@RestController
public class TestController {
	protected static Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	TestService testService;

	@GetMapping("/hello")
	public void hello(String name) throws InterruptedException {
		logger.info("redis锁{}", name);
		RedisUtils.lockWithTimeout("zlx", name, 5, TimeUnit.MINUTES);
		for (int i = 0; i < 5; i++) {
			Thread.sleep(2000);
			System.out.println("name = " + name);
		}
		logger.info("redis解锁{}", name);
		RedisUtils.unlock("zlx", name);

	}
//	@Resource
//	RedissonClient redissonClient;
//	@GetMapping("/test")
//	public void test() throws InterruptedException {
//		RLock rLock = redissonClient.getLock("123" + this.getClass().getName());
//		boolean lock = rLock.tryLock(1, TimeUnit.MINUTES);
//		if (lock) {
//			Thread.sleep(500);
//			System.out.println(Thread.currentThread().getName() + "拿到了锁");
//			if (rLock.isLocked() && rLock.isHeldByCurrentThread()) {
//				rLock.unlock();
//				System.out.println(Thread.currentThread().getName() + "释放了锁");
//			}
//			return;
//		}
//		System.out.println(Thread.currentThread().getName() + "没拿到锁");
//	}
}
