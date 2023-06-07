package com.nuracell.shelltest.exception.resolver;

import com.nuracell.shelltest.exception.CustomException;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver implements CommandExceptionResolver {
    @Override
    public CommandHandlingResult resolve(Exception ex) {
        if (ex instanceof CustomException) {
            return CommandHandlingResult.of("Hi, handled exception\n", 42);
        }
        return null;
    }
}
