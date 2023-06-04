package com.nuracell.shelltest.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {

    // 1.
    // shell:>hello-world
    // Hello world spring

    // 2.
    // shell:>hello-world --arg ArG
    // Hello world ArG
    @ShellMethod(key = "hello-world")
    public String helloWorld(@ShellOption(defaultValue = "spring") String arg) {
        return "Hello world " + arg;
    }


}
