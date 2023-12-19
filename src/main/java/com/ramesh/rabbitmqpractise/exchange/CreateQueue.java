package com.ramesh.rabbitmqpractise.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.ramesh.rabbitmqpractise.queue.CommonConfigs;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CreateQueue {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.newConnection(CommonConfigs.AMQP_URL);
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("MobileQ", true, false, false, null);
            channel.queueDeclare("ACQ", true, false, false, null);
            channel.queueDeclare("LightQ", true, false, false, null);
        }
    }
}
