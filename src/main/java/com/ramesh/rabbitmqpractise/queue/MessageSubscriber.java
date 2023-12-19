package com.ramesh.rabbitmqpractise.queue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class MessageSubscriber {

    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println("program start !!!");
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection(CommonConfigs.AMQP_URL);
        Channel channel = connection.createChannel();
        DeliverCallback deliverCallback = (s, delivery) -> System.out.println(new String(delivery.getBody(), StandardCharsets.UTF_8));

        CancelCallback cancelCallback = consumerTag -> System.out.println(consumerTag);

        channel.basicConsume(CommonConfigs.DEFAULT_QUEUE, true, deliverCallback, cancelCallback);

        System.out.println("program run successfully !!");
    }
}

