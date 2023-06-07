package com.nuracell.shelltest.command.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.context.InteractionMode;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@Configuration
@ShellComponent
public class D47_InteractionMode {

    @Bean
    public CommandRegistration commandRegistrationInteractionModeAll() {
        return CommandRegistration.builder()
                .command("i-all")
                .withTarget()
                    .function((cc) -> "interactionMode ALL")
                .and()
                .interactionMode(InteractionMode.ALL)
                .build();
    }

    @Bean
    public CommandRegistration commandRegistrationInteractionModeInteractive() {
        return CommandRegistration.builder()
                .command("i-interactive")
                .withTarget()
                .function((cc) -> "interactionMode INTERACTIVE")
                .and()
                .interactionMode(InteractionMode.INTERACTIVE)
                .build();
    }

    @Bean
    public CommandRegistration commandRegistrationInteractionModeNonInteractive() {
        return CommandRegistration.builder()
                .command("i-noninteractive")
                .withTarget()
                .function((cc) -> "interactionMode NONINTERACTIVE")
                .and()
                .interactionMode(InteractionMode.NONINTERACTIVE)
                .build();
    }

    @ShellMethod(key = "shell-interactive", interactionMode = InteractionMode.INTERACTIVE)
    public String shellMethodInteractionMode() {
        return "Interactive shell method";
    }
}
