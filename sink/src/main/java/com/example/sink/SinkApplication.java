package com.example.sink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void consumeData(String data) {
		System.out.println("***********************"
				+"Received: "
				+ data
				+"*********"+ LocalDateTime.now().toString() + "*********");
	}
}