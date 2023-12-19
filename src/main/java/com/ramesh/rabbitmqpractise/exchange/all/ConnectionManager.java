package com.ramesh.rabbitmqpractise.exchange.all;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionManager {

    public static Connection connection;

    /**
     * Create RabbitMQ Connection
     *
     * @return Connection
     */
    public static Connection getConnection() {
        if (connection == null) {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            try {
                connection = connectionFactory.newConnection("amqp://guest:guest@localhost:5672/");
            } catch (IOException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
