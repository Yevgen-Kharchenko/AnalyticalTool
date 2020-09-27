package com.analyticTool.service;

import java.util.Scanner;


public class UserInteractionService {
    private static final String PATH = "resources\\";
    private static final String testFile = "data";
    private Scanner scanner = new Scanner(System.in);

    void showMessage(String message) {
        System.out.printf("\n**************************************************\n%s" +
                "\n**************************************************\n", message);
    }
    void showErrorLine() {
        System.out.printf("The line contains an error");
    }

    String getUserFilePath() {
        showMessage("Enter a file name for the analytics or press enter for test file analytics");
        String fileName = scanner.nextLine();
        if (fileName.equals("")) fileName = testFile;
        return PATH+fileName;
    }

}
