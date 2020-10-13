package org.demon;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit // 开启基于注解的 RabbitMQ 模式
@SpringBootApplication
public class MessageAmpqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageAmpqApplication.class, args);
	}

}
