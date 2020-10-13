package org.demon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	public void testSimpleSend(){
		SimpleMailMessage message = new SimpleMailMessage();

		//邮件设置
		message.setSubject("SpringBoot 测试");
		message.setText("Success!");
		message.setTo("xxx@xx.com");
		message.setFrom("xxxx@163.com");

		mailSender.send(message);
	}

	@Test
	public void testMimeSend() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true); // 有附件上传

		// 邮件设置
		helper.setSubject("SpringBoot + 附件");
		helper.setText("<b style='color:purple'>Success!有附件！</b>", true);
		helper.setTo("xxx@xx.com");
		helper.setFrom("xxxx@163.com");

		// 添加附件
		helper.addAttachment("hello.jpg", new File("E:\\xx\\xx\\jf.jpg"));

		mailSender.send(mimeMessage);
	}

}
