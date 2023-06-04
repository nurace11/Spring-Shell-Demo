package com.nuracell.shelltest.command;

import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.annotation.Command;
import org.springframework.stereotype.Component;

@Command(command = "acr", group = "Test")
public class AnnotationCommandRegistration {

    @Command(command = "hi", description = "Prints hello")
    public String example() {
        return "Hello";
    }
}
