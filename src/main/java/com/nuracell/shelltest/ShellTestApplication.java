package com.nuracell.shelltest;

import com.nuracell.shelltest.command.AnnotationCommandRegistration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.shell.command.annotation.CommandScan;
import org.springframework.shell.command.annotation.EnableCommand;
import org.springframework.web.context.support.RequestHandledEvent;

@EnableCommand(AnnotationCommandRegistration.class) // or use @CommandScan to register annotated commands
@CommandScan
@SpringBootApplication
@EnableFeignClients
@Configuration
public class ShellTestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ShellTestApplication.class);

		context.start();

		context.stop();

		SpringApplication.run(ShellTestApplication.class, args);
	}

	@Bean
	public ApplicationListener<ContextStartedEvent> contextStartedEventApplicationListener() {
		return event -> System.out.println("ContextStartedEvent Received");
	}

	@Bean
	public ApplicationListener<ContextStoppedEvent> contextStoppedEventApplicationListener() {
		return event -> System.out.println("ContextStoppedEvent Received");
	}
}
