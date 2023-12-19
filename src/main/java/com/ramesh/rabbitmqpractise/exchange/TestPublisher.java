package com.ramesh.rabbitmqpractise.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.ramesh.rabbitmqpractise.queue.CommonConfigs;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestPublisher {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.newConnection(CommonConfigs.AMQP_URL);
             Channel channel = connection.createChannel()) {
            String message = "turn on home appliance";
            channel.basicPublish("my-direct-exchange", "homeAppliance", null, message.getBytes());
        }
    }
}
