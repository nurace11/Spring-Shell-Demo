package com.nuracell.shelltest.command.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.CommandRegistration;

@Configuration
public class D46_HiddenCommand {

    @Bean
    public CommandRegistration hiddenCommandRegistration() {
        return CommandRegistration.builder()
                .command("secret")
                .withTarget()
                    .function((cc) -> "You found a secret command (for debug purposes only)")

                .and()
                .hidden()
                .build();
    }
}
