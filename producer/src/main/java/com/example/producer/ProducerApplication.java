package com.example.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

@SpringBootApplication
@EnableBinding(Source.class)
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000"))
	public String produceData() {
		return "Hello, Spring Cloud Data Flow!";
	}
}