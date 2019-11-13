package com.hvkcoder.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * @author h-vk
 * @date 2019-10-25
 * @since V1.0
 */
public class PointToPoint {

  /** TODO: ActiveMQ 点对点发送消息 */
  @Test
  public void testSendMessage() throws JMSException {
    // 创建连接 ActiveMQFactory
    ConnectionFactory connectionFactory =
        new ActiveMQConnectionFactory("tcp://192.168.249.160:61616");
    // 从 Factory 中获取连接
    Connection connection = connectionFactory.createConnection();
    // 连接 ActiveMQ
    connection.start();

    /** TODO: 创建 Session 第一个参数表示是否启用事务，一般在分布式中使用，如果第一个为 true 则第二个参数无效 第二个参数表示 应答方式： 自动应答， 手动应答 */
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

    // 创建消息队列
    Queue queue = session.createQueue("queue");
    // 创建消息生产者
    MessageProducer producer = session.createProducer(queue);
    // 创建发送类型
    TextMessage hello_world = session.createTextMessage("Hello World");
    // 发送消息
    producer.send(hello_world);

    // 释放资源
    producer.close();
    session.close();
    connection.close();
  }

  /** TODO: ActiveMQ 点对点接收消息 */
  @Test
  public void testReceiveMessage() throws JMSException, IOException {
    // 创建 ActiveMQ Factory
    ConnectionFactory connectionFactory =
        new ActiveMQConnectionFactory("tcp://192.168.249.160:61616");
    // 从 Factory 冲获取 连接
    Connection connection = connectionFactory.createConnection();
    // 连接 ActiveMQ
    connection.start();
    // 创建 Session
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    // 创建队列目的地
    Queue queue = session.createQueue("queue");
    // 创建消费者
    MessageConsumer consumer = session.createConsumer(queue);
    // 设置 消息监听
    consumer.setMessageListener(
        new MessageListener() {
          public void onMessage(Message message) {
            try {
              // 处理接收的消息数据
              TextMessage textMessage = (TextMessage) message;
              System.out.println(textMessage.getText());
            } catch (JMSException e) {
              e.printStackTrace();
            }
          }
        });

    // 释放资源
    System.in.read(); // 用于阻塞执行，防止为接收到消息，导致资源释放
    consumer.close();
    session.close();
    connection.close();
  }
}
