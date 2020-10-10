package org.demon.service;

import org.demon.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    /**
     * 主配置类上增加 @EnableRabbit 开启基于注解的 RabbitMQ 模式
     *  + @RabbitListener 注解
     *  即可实现监听，即队列中只要插入 book 信息，即可及时取出
     */
    @RabbitListener(queues = {"user.test"})
    public void receive(Book book){
        System.out.println("user.test 队列收到消息：" + book);
    }

    /**
     * 另外一种取出消息的方式
     * @param msg
     */
    @RabbitListener(queues= {"user.main"})
    public void receive02(Message msg){
        System.out.println(msg.getBody());
    }
}
