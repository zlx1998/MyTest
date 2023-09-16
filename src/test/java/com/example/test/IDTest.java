package com.example.test;

import cn.hutool.core.collection.ConcurrentHashSet;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author zhanglixiang
 * @date 2023/7/3 16:38
 */
public class IDTest {

	@Test
	void test(){
		// 测试并发环境下生成ID是否重复
//		final Snowflake snowflake = IdUtil.getSnowflake(20, 0);
		final Set<String> ids = new ConcurrentHashSet<>();
		for (int i = 0; i < 10000; i++) {
			if (!ids.add(idUid())) {
				System.out.println("G");
			}
//			System.out.println("i = " + idUid());
		}
	}
	String idUid(){
		final Snowflake snowflake = IdUtil.getSnowflake();
		return "32" + snowflake.nextIdStr().substring(1, 19);
	}
}
