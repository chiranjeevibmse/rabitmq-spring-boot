package com.chiru.amqp.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQDirectConfig
 */
@Configuration
public class RabbitMQDirectConfig {
    @Bean
	Queue marketingQueue() {
		return new Queue("participantQ", false);
	}

	@Bean
	Queue financeQueue() {
		return new Queue("channelQ", false);
	}

	@Bean
	Queue adminQueue() {
		return new Queue("adminQ", false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange("direct-exchange");
	}

	@Bean
	Binding marketingBinding(Queue marketingQueue, DirectExchange exchange) {
		return BindingBuilder.bind(marketingQueue).to(exchange).with("participant-create");
	}

	@Bean
	Binding financeBinding(Queue financeQueue, DirectExchange exchange) {
		return BindingBuilder.bind(financeQueue).to(exchange).with("channel-create");
	}

	@Bean
	Binding adminBinding(Queue adminQueue, DirectExchange exchange) {
		return BindingBuilder.bind(adminQueue).to(exchange).with("admin");
	}
    
}