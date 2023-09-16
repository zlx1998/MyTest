package com.example.test.service;

import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Service;

/**
 * @author zlx
 * @date 2022/7/19 10:31
 */
@Service
public class TestServiceImpl implements TestService{

	@Override
	public void run() {
//		synchronized (this) {
			int cout = 0;
			for (int i = 0; i < 10; i++) {
				cout++;
				System.out.println(cout);
			}
//		}
	}

//	@Scheduled(fixedDelay = 5000)
	@Override
	public void testTask() {
		for (int i = 0; i < 3; i++) {
			System.out.println("i = " + i);
			System.out.println("DateUtil.now() = " + DateUtil.now());

		}
	}
}
