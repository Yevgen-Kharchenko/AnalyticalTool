package com.analyticTool.service;

import java.util.Scanner;


public class UserInteractionService {
    private static final String PATH = "resources\\";
    private static final String testFile = "data";
    private Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.printf("\n**************************************************\n%s" +
                "\n**************************************************\n", message);
    }

    public void showErrorLine() {
        System.err.println("The line contains an error");
    }

    public String getUserFilePath() {
        showMessage("Enter a file name for the analytics or press enter for test file analytics");
        String fileName = scanner.nextLine();
        if (fileName.equals("")) fileName = testFile;
        return PATH + fileName;
    }

    public void printResult(String message) {
        System.out.println(message);
    }
}
