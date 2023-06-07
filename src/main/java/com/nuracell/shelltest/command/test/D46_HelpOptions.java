package com.nuracell.shelltest.command.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.CommandRegistration;

@Configuration
public class D46_HelpOptions {

    @Bean
    public CommandRegistration commandRegistrationWithHelpOptions() {
        return CommandRegistration.builder()
                .command("help-options")
                .withTarget()
                .function((cc) -> "help options")

                .and()
                .withHelpOptions()
                    .enabled(true)
                    .longNames("help")
                    .shortNames('h')
                    .command("help")

                .and()
                .build();
    }
}
