package com.nuracell.shelltest.exception;

import org.springframework.boot.ExitCodeGenerator;

public class CustomExceptionWithErrorCode extends RuntimeException implements ExitCodeGenerator {
    private final int code;

    public CustomExceptionWithErrorCode(String msg, int code) {
        super(msg);
        this.code = code;
    }

    @Override
    public int getExitCode() {
        //Errors from a command option parsing will result code of 2
        //
        //Any generic error will result result code of 1
        //
        //Obviously in any other case result code is 0

        return code;
    }

    @Deprecated
    public int getCode() {
        return code;
    }
}
