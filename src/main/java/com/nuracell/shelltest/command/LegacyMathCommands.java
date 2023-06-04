package com.nuracell.shelltest.command;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@ShellCommandGroup(value = "Math")
public class LegacyMathCommands {

    // array-sum 1,2,3,4,5
    @ShellMethod(value = "", key = "array-sum")
    public Integer sum(int... numbers) {
        int sum = 0;

        for (Integer i : numbers) {
            sum += i;
        }

        return sum;
    }
}
