package com.ramesh.rabbitmqpractise.exchange;

import com.rabbitmq.client.*;
import com.ramesh.rabbitmqpractise.queue.CommonConfigs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class TestSubscriber {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection(CommonConfigs.AMQP_URL);
        Channel channel = connection.createChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
        CancelCallback cancelCallback = consumerTag -> System.out.println(consumerTag);

        channel.basicConsume("MobileQ", true, deliverCallback, cancelCallback);
        channel.basicConsume("ACQ", true, deliverCallback, cancelCallback);
        channel.basicConsume("LightQ", true, deliverCallback, cancelCallback);
    }
}
