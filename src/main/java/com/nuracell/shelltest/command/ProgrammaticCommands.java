package com.nuracell.shelltest.command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.CommandRegistration;

@Configuration
public class ProgrammaticCommands {

    @Bean
    public CommandRegistration commandRegistration1() {
        return CommandRegistration.builder()
                .withTarget()
                .and()
                .command("mycommand1")
                .build();
    }

    int c = 0;

    @Bean
    public CommandRegistration commandRegistration2(CommandRegistration.BuilderSupplier builder) {
        return builder.get()
                .command("mc2")
                .withTarget().function((commandContext) -> "ASDASD " + ++c)
                .and()
                .build();
    }
}

