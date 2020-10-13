package org.demon;

import org.demon.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MessageAmpqApplicationTests {

	/**
	 * 自动配置类会提供
	 * 一个 RabbitTemplate 对象：给 RabbitMQ 发送和接受消息；
	 * 一个 AmqpAdmin 创建和删除 Queue, Exchange, Binding
	 */
	@Autowired
	RabbitTemplate template;

	@Autowired
	AmqpAdmin admin;

	@Test
	void sendDirect() {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "First Message!");
		map.put("data", Arrays.asList("hello rabbitMQ", 777, true));
		/**
		 * 第一个参数 exchange
		 * 第二个参数 routing key
		 * 第三个参数 传递的消息，只需要传入要发送的对象，自动序列化发送给 rabbitmq
		 */
		template.convertAndSend("exchange.direct", "demon.test", map); // 点对点
	}


	@Test
	void sendFanout() {
		template.convertAndSend("exchange.fanout", "",new Book("漫长的告别", "雷德蒙·钱德勒")); // 广播
	}

	@Test
	void sendTopic(){
		template.convertAndSend("exchange.topic", "demon.test", new Book("ABC谋杀案", "阿加莎·克里斯蒂")); // 模式匹配
	}

	@Test
	void receive(){
		Object o = template.receiveAndConvert("user.test");
		System.out.println(o.getClass());
		System.out.println(o);
	}


	@Test
	void createExchange(){
		// 可以通过不同的实现类创建不同类型的 exchange
		admin.declareExchange(new DirectExchange("amqpadmin.exchange"));
	}

	@Test
	void createQueue(){
		// 第二个参数是是否持久
		admin.declareQueue(new Queue("amqpadmin.queue", false));
	}

	@Test
	void createBinding(){
		admin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "ampq.test", null));
	}

}
