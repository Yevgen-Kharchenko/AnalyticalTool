package com.analyticTool.service;

import java.util.Arrays;

public class MainService {
    private UserInteractionService userInteractionService = new UserInteractionService();
    private FileReader fileReader = new FileReader();
    private String[] queryArray;

    public void doAnalytics() {
        readFile();
        userInteractionService.showMessage(Arrays.toString(queryArray));
    }

    public void readFile() {
        String fileName = userInteractionService.getUserFilePath();
        queryArray = fileReader.readMyFile(fileName);
        if(queryArray.length==0) readFile();

    }

}
