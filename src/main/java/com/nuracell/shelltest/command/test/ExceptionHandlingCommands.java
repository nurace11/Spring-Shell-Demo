package com.nuracell.shelltest.command.test;

import com.nuracell.shelltest.exception.CustomException;
import com.nuracell.shelltest.exception.CustomExceptionWithErrorCode;
import com.nuracell.shelltest.exception.resolver.CustomExceptionResolver;
import org.springframework.asm.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.command.annotation.Command;

@Command(group = "Exception Test")
public class ExceptionHandlingCommands {

    @Command(command = "custom-exception")
    public String throwCustomException() throws CustomException {
        throw new CustomException();
    }

    @Bean
    public CommandRegistration commandRegistrationWithExceptionHandling(CustomExceptionResolver resolver) {
        return CommandRegistration.builder()
                .group("Exception Test")
                .command("programmatic-exception")
                .withOption()
                    .longNames("arg", "argument")
                    .shortNames('a')
                    .defaultValue("arg")
                    .type(Type.LONG_TYPE.getClass())

                .and()
                .withTarget()
                    .function((c) -> {

                        Object arg = c.getOptionValue("arg");
                        long val;

                        try {
                            val = Long.parseLong((String) arg);
                        } catch (Exception e) {
                            throw new CustomException();
                        }

                        return "asd " + val;
                    })

                .and()
                .withErrorHandling()
                    .resolver(resolver)

                .and()
                .build();
    }

    @Bean
    public CommandRegistration commandRegistrationWithExitCode() {
        return CommandRegistration.builder()
                .command("exitcode")
                .withTarget().function((c) -> {
                    throw new CustomExceptionWithErrorCode("MSG", 4);
                })

                .and()
                .withExitCode()
                .map(CustomExceptionWithErrorCode.class, 3)
                .map(t -> {
                    if (t instanceof CustomExceptionWithErrorCode) {
                        return ((CustomExceptionWithErrorCode) t).getExitCode();
                    }

                    return 0;
                })

                .and()
                .build();
    }
}
