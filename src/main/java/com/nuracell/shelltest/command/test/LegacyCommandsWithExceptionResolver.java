package com.nuracell.shelltest.command.test;

import com.nuracell.shelltest.exception.CustomException;
import com.nuracell.shelltest.exception.CustomExceptionWithErrorCode;
import org.jline.terminal.Terminal;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.command.annotation.ExitCode;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.PrintWriter;

@ShellComponent
public class LegacyCommandsWithExceptionResolver {

    @ShellMethod(key = "cstm-ex")
    public String legacyThrowException() {
        throw new CustomException();
    }

    @ExceptionResolver({CustomException.class})
    CommandHandlingResult errorHandler(Exception e) {
        return CommandHandlingResult.of("ShellComponent @ExceptionResolver\n");
    }


    @ShellMethod(key = "error5")
    public String throwExceptionWIthExitCode5() {
        throw new CustomExceptionWithErrorCode("Error 5", 5);
    }

    @ExceptionResolver
    @ExitCode(code = 5)
    String exitCode5Handler(Exception e) {
        return "Handle exit code 5: " + e.getMessage() + "\n";
    }


//    @ShellMethod(key = "error6")
//    public String throwExceptionWithExitCode6() {
//        throw new CustomExceptionWithErrorCode("Error 6", 6);
//    }
//
//    @ExceptionResolver
//    @ExitCode(code = 6)
//    void exitCode6Handler (Exception e, Terminal terminal) {
//        PrintWriter writer = terminal.writer();
//        String msg =  "Hi, handled exception ";
//        writer.println(msg);
//        writer.flush();
//    }


}
