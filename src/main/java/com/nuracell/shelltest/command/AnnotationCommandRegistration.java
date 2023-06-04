package com.nuracell.shelltest.command;

import org.springframework.shell.command.annotation.Command;

@Command(command = "acr", group = "Test")
public class AnnotationCommandRegistration {

    @Command(command = "hi", description = "Prints hello")
    public String example() {
        return "Hello";
    }
}
