package org.example.directexchange.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderProcessingConfig {

    public static final String ORDER_DIRECT_EXCHANGE = "order-direct-exchange";
    public static final String PAYMENT_QUEUE = "payment-queue";
    public static final String INVENTORY_QUEUE = "inventory-queue";
    public static final String SHIPPING_QUEUE = "shipping-queue";
    public static final String NOTIFICATION_QUEUE = "notification-queue";
    public static final String ROUTING_KEY_NOTIFICATION = "order.created";
    public static final String ROUTING_KEY_PAYMENT = "payment";
    public static final String ROUTING_KEY_INVENTORY = "inventory";
    public static final String ROUTING_KEY_SHIPPING = "shipping";

    @Bean
    public DirectExchange orderDirectExchange() {
        return new DirectExchange(ORDER_DIRECT_EXCHANGE);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(PAYMENT_QUEUE);
    }

    @Bean
    public Queue notQueue() {
        return new Queue(NOTIFICATION_QUEUE);
    }

    @Bean
    public Queue inventoryQueue() {
        return new Queue(INVENTORY_QUEUE);
    }

    @Bean
    public Queue shippingQueue() {
        return new Queue(SHIPPING_QUEUE);
    }

    @Bean
    public Binding paymentBinding() {
        return BindingBuilder
                .bind(paymentQueue())
                .to(orderDirectExchange())
                .with(ROUTING_KEY_PAYMENT);
    }

    @Bean
    public Binding inventoryBinding() {
        return BindingBuilder
                .bind(inventoryQueue())
                .to(orderDirectExchange())
                .with(ROUTING_KEY_INVENTORY);
    }

    @Bean
    public Binding shippingBinding() {
        return BindingBuilder
                .bind(shippingQueue())
                .to(orderDirectExchange())
                .with(ROUTING_KEY_SHIPPING);
    }

    @Bean
    public Binding notifBinding() {
        return BindingBuilder
                .bind(notQueue())
                .to(orderDirectExchange())
                .with(ROUTING_KEY_NOTIFICATION);
    }
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}