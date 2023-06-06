package com.nuracell.shelltest;

import java.io.*;
import java.util.Scanner;

public class ProcessShell {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c",
                "chcp 65001 && " +
                "dir && " +
                "java --version && " +
                        "java -jar target/shell-test-0.0.1-SNAPSHOT.jar");

        Process process = processBuilder.start();

        BufferedReader bufferedInputStream = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );

        BufferedWriter os = new BufferedWriter(
                new OutputStreamWriter(process.getOutputStream())
        );

        Thread th1 = new Thread(() -> {
            System.out.println("Thread for ");
            Scanner scanner = new Scanner(System.in);
            String s;
            while( !(s = scanner.nextLine()).equals("exit") ) {
                try {
                    System.out.println(s);
                    os.write(s);
                    os.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        th1.start();

        String line;
        while ((line = bufferedInputStream.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("Done");
    }
}
