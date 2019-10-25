package com.hvkcoder.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * 发布订阅消息方式 必须 消费者和 生产者同时存在
 * @author h-vk
 * @date 2019-10-25
 * @since V1.0
 */
public class PubAndSub {

    /**
     * 创建发布订阅发送消息
     */
    @Test
    public void testSendMessage() throws JMSException {
        // 创建 ActiveMQ Factory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.249.160:61616");
        // 获取连接
        Connection connection = connectionFactory.createConnection();
        // 连接 ActiveMQ
        connection.start();
        // 创建 Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 在发布订阅中 使用 topic 创建消息发送目的地
        Topic topic = session.createTopic("topic");
        // 创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        // 创建消息类型
        TextMessage hello_world = session.createTextMessage("Hello World");
        // 发送消息
        producer.send(hello_world);
        // 释放资源
        producer.close();
        session.close();
        connection.close();
    }

    /**
     * 创建发布订阅接收消息
     */
    @Test
    public void testReceiveMessage() throws JMSException, IOException {
        // 创建 ActiveMQ Factory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.249.160:61616");
        // 从 Factory 中获取连接
        Connection connection = connectionFactory.createConnection();
        // 连接 ActiveMQ
        connection.start();
        // 创建 Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建发布订阅目的地
        Topic topic = session.createTopic("topic");
        // 创建消费者
        MessageConsumer consumer = session.createConsumer(topic);
        // 监听消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        System.in.read();
        System.in.read(); // 用于阻塞执行，防止为接收到消息，导致资源释放
        consumer.close();
        session.close();
        connection.close();
    }
}
