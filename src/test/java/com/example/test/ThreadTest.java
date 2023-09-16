package com.example.test;

import org.junit.jupiter.api.Test;

/**
 * @author zlx
 * @date 2022/7/19 10:43
 */
public class ThreadTest implements Runnable {
	int count = 0;

	@Override
	public synchronized void run() {
//		synchronized (this) {
		for (int i = 0; i < 200000; i++) {
			count++;
			System.out.println("count = " + count);
		}
//		}
	}

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		ThreadTest threadTest1 = new ThreadTest();
		Thread thread1 = new Thread(threadTest);
		Thread thread2 = new Thread(threadTest1);
		thread1.start();
		thread2.start();
	}

	@Test
	void test() {
		for (int i = 1; i < 3; i++) {
			System.out.println("i = " + i);
			for (int j = 1; j < 4; j++) {
				try {
					if (i == 2 && j == 2) {
						int s = 2 / 0;
					}
					System.out.println("j = " + j);
				} catch (Exception e) {
					break;
				}
			}
		}
	}
}
