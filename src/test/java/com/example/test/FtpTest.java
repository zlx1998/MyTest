package com.example.test;

import cn.hutool.extra.ssh.Sftp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;

/**
 * @author zhanglixiang
 * @date 2023/8/25 10:33
 */
@SpringBootTest
public class FtpTest {
	@Test
	public void ftp() {
		String ip = "172.23.44.13";
		Integer port = 8222;
		String accountId = "cssnj_s";
		String accountSecret = "CssnjSftp@second#M";
		ByteArrayOutputStream os = null;
		Sftp sftp = new Sftp(ip, port, accountId, accountSecret);
		sftp.get("/fir/tfxx/03936B66E2B80190E0634D0C4C4CE3DA/江苏省医学会", "D:\\Aliyun");


	}
}
