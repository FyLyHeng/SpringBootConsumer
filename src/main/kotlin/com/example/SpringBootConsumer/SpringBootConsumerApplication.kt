package com.example.SpringBootConsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class SpringBootConsumerApplication

fun main(args: Array<String>) {
	runApplication<SpringBootConsumerApplication>(*args)
}

@Bean
fun getRestTemplate():RestTemplate{
	return RestTemplate()
}
