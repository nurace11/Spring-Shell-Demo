package com.nuracell.shelltest;

import com.nuracell.shelltest.command.AnnotationCommandRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.shell.command.annotation.CommandScan;
import org.springframework.shell.command.annotation.EnableCommand;

@EnableCommand(AnnotationCommandRegistration.class) // or use @CommandScan to register annotated commands
@CommandScan
@SpringBootApplication
@EnableFeignClients
public class ShellTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShellTestApplication.class, args);
	}

}
