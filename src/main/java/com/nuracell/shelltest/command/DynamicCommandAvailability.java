package com.nuracell.shelltest.command;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@ShellComponent
@ShellCommandGroup(value = "Dynamic Command Availability")
public class DynamicCommandAvailability {

    private boolean connected;

    @ShellMethod("Connect to the server.")
    private void connect(String user, String password) {
        connected = true;
    }

    @ShellMethod(value = "Download", key = "download")
    public String dwnld() throws IOException {
        String fileName = UUID.randomUUID().toString();
        try (FileOutputStream fos = new FileOutputStream(new File("files/" + fileName))) {
            fos.write(UUID.randomUUID().toString().getBytes());
            return "Successfully downloaded %s".formatted(fileName);
        } catch (Exception e) {
            return "Failed to download %s".formatted(e);
        }
    }

    // refers to the method name
    public Availability dwnldAvailability() {
        return connected ? Availability.available() : Availability.unavailable("you are not connected");
    }

    @ShellMethod("Command with long name")
    @ShellMethodAvailability("commandWithBigNameAvailabilityCheck")
    public String commandWithLongName() {
        return "Ok";
    }

    public Availability commandWithBigNameAvailabilityCheck() {
        return connected ? Availability.available() : Availability.unavailable("not connected");
    }
}
