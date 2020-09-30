package com.analyticTool.controller;

import com.analyticTool.exception.ResponseTypeException;
import com.analyticTool.model.*;
import com.analyticTool.service.DataAnalytics;
import com.analyticTool.service.FileReader;
import com.analyticTool.service.UserInteractionService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    private UserInteractionService userInteractionService = new UserInteractionService();
    private DataAnalytics dataAnalytics = new DataAnalytics();
    private FileReader fileReader = new FileReader();
    private List<Question> questionList = new ArrayList<>();
    private String[] lineArray;


    public void doAnalytics() {
        readFile();

        for (String line : lineArray) {
            String[] splitLine = line.split(" ");
            if (splitLine[0].equals("C")) {
                Question question = createQuestion(splitLine);
                questionList.add(question);
            } else if (splitLine[0].equals("D")) {
                Query query = createQuery(splitLine);
                List<Question> filteredList = dataAnalytics.filterData(questionList, query);
                String result;
                if (filteredList.isEmpty()) result = "-";
                else result = String.valueOf(averageWaitingTime(filteredList));
                userInteractionService.printResult(result);
            } else userInteractionService.showErrorLine();
        }
    }


    private int averageWaitingTime(List<Question> filteredList) {
        int sum = 0;
        int count = 0;
        for (Question element : filteredList) {
            sum += element.getTime();
            count++;
        }
        return sum / count;
    }

    private Query createQuery(String[] splitLine) {
        ServiceDTO serviceDTO = fileReader.parseServiceDto(splitLine[1]);
        int serviceId = serviceDTO.getServiceId();
        int variationId = serviceDTO.getVariationId();

        QuestionTypeDTO questionTypeDTO = fileReader.parseQuestionTypeDTO(splitLine[2]);
        int questionTypeId = questionTypeDTO.getQuestionTypeId();
        int categoryId = questionTypeDTO.getCategoryId();
        int subCategoryId = questionTypeDTO.getSubCategoryId();

        String responseType = null;
        try {
            responseType = fileReader.getResponseType(splitLine[3]);
        } catch (ResponseTypeException ex) {
            ex.getMessage();
        }

        DateDTO dateDTO = fileReader.parseDateDTO(splitLine[4]);
        LocalDate dateFrom = dateDTO.getDateFrom();
        LocalDate dateTo = dateDTO.getDateTo();

        return new Query(serviceId, variationId,
                questionTypeId, categoryId,
                subCategoryId, responseType,
                dateFrom, dateTo);
    }

    private Question createQuestion(String[] splitLine) {

        ServiceDTO serviceDTO = fileReader.parseServiceDto(splitLine[1]);
        int serviceId = serviceDTO.getServiceId();
        int variationId = serviceDTO.getVariationId();

        QuestionTypeDTO questionTypeDTO = fileReader.parseQuestionTypeDTO(splitLine[2]);
        int questionTypeId = questionTypeDTO.getQuestionTypeId();
        int categoryId = questionTypeDTO.getCategoryId();
        int subCategoryId = questionTypeDTO.getSubCategoryId();

        String responseType = null;
        try {
            responseType = fileReader.getResponseType(splitLine[3]);
        } catch (ResponseTypeException ex) {
            ex.getMessage();
        }

        DateDTO dateDTO = fileReader.parseDateDTO(splitLine[4]);
        LocalDate date = dateDTO.getDateFrom();

        int time = Integer.parseInt(splitLine[5]);

        return new Question(serviceId, variationId,
                questionTypeId, categoryId,
                subCategoryId, responseType,
                date, time);
    }

    public void readFile() {
        String fileName = userInteractionService.getUserFilePath();
        lineArray = fileReader.readMyFile(fileName);
        if (lineArray.length == 0) readFile();
    }

}
