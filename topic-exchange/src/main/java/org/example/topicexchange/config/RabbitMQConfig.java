package org.example.topicexchange.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("order-logs-exchange",true    ,false);
    }

    @Bean
    public Queue customerOrdersQueue() {
        return new Queue("customer_orders_queue");
    }

    @Bean
    public Queue allOrderLogsQueue() {
        return new Queue("all_order_logs_queue");
    }

    @Bean
    public Queue electronicsOrderLogsQueue() {
        return new Queue("electronics_order_logs_queue");
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(customerOrdersQueue())
                .to(topicExchange())
                .with("order.logs.customer.#");
    }

    @Bean
    public Binding binding2(TopicExchange topicExchange, Queue allOrderLogsQueue) {
        return BindingBuilder.bind(allOrderLogsQueue)
                .to(topicExchange)
                .with("order.logs.#");
    }

    @Bean
    public Binding binding3(TopicExchange topicExchange, Queue electronicsOrderLogsQueue) {
        return BindingBuilder.bind(electronicsOrderLogsQueue)
                .to(topicExchange)
                .with("order.logs.*.electronics");
    }
}