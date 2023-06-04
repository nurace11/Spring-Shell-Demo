package com.nuracell.shelltest.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class LegacyAnnotationCommandRegistration {

    @ShellMethod(value = "Description. Description should be no more  than one or two sentences.")
    public void myCommand() {

    }

    @ShellMethod(value = "Add numbers.", key = "sum")
    public int add(int a, int b){
        return a + b;
    }
}
