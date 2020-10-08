package com.analyticTool.service;

import com.analyticTool.exception.ResponseTypeException;
import com.analyticTool.model.DateDTO;
import com.analyticTool.model.QuestionTypeDTO;
import com.analyticTool.model.ServiceDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {

    public String[] readMyFile(String path) {
        File file = new File(path);

        Scanner scanner;

        {
            try {
                scanner = new Scanner(file);
                String line = scanner.nextLine();
                int count = Integer.parseInt(line);

                String[] query = new String[count];
                try {
                    for (int i = 0; i < count; i++) {

                        String data = scanner.nextLine();
                        query[i] = data;
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("The number of tapes in the file does not match the stated");
                    return new String[0];
                }

                scanner.close();
                return query;

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        return new String[0];
    }

    public String getResponseType(String splitLine) {
        String responseType = "Error";
        if (splitLine.equals("N") || splitLine.equals("P") || splitLine.equals("*")) {
            responseType = splitLine;
        } else {
            throw new ResponseTypeException();
        }
        return responseType;

    }

    public DateDTO parseDateDTO(String dateString) {
        DateDTO dateDTO = new DateDTO();

        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ENGLISH);

        String[] splitDate = dateString.split("-");

        if (splitDate.length == 0 || splitDate.length > 2) {
            System.out.println("Error in date");
            return dateDTO;

        } else if (splitDate.length == 2) {
            dateDTO.setDateFrom(LocalDate.parse(splitDate[0], formatter));
            dateDTO.setDateTo(LocalDate.parse(splitDate[1], formatter));
            return dateDTO;
        } else {
            dateDTO.setDateFrom(LocalDate.parse(splitDate[0], formatter));
            dateDTO.setDateTo(LocalDate.parse(splitDate[0], formatter));
        }
        return dateDTO;
    }

    public ServiceDTO parseServiceDto(String service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        String[] splitService = service.split("\\.");
        if (splitService.length == 0 || splitService.length > 2) {
            System.out.println("Error in service id");
            return serviceDTO;
        } else if (splitService[0].equals("*")) {
            return serviceDTO;
        } else if (splitService.length == 2) {
            serviceDTO.setServiceId(Integer.parseInt(splitService[0]));
            serviceDTO.setVariationId(Integer.parseInt(splitService[1]));
            return serviceDTO;
        } else serviceDTO.setServiceId(Integer.parseInt(splitService[0]));
        return serviceDTO;
    }

    public QuestionTypeDTO parseQuestionTypeDTO(String question) {
        QuestionTypeDTO questionTypeDTO = new QuestionTypeDTO();
        String[] splitQuestion = question.split("\\.");
        if (splitQuestion.length == 0 || splitQuestion.length > 3) {
            System.out.println("Error in question id");
            return questionTypeDTO;
        } else if (splitQuestion[0].equals("*")) {
            return questionTypeDTO;
        } else if (splitQuestion.length == 3) {
            questionTypeDTO.setQuestionTypeId(Integer.parseInt(splitQuestion[0]));
            questionTypeDTO.setCategoryId(Integer.parseInt(splitQuestion[1]));
            questionTypeDTO.setSubCategoryId(Integer.parseInt(splitQuestion[2]));
            return questionTypeDTO;
        } else if (splitQuestion.length == 2) {
            questionTypeDTO.setQuestionTypeId(Integer.parseInt(splitQuestion[0]));
            questionTypeDTO.setCategoryId(Integer.parseInt(splitQuestion[1]));
            return questionTypeDTO;
        } else questionTypeDTO.setQuestionTypeId(Integer.parseInt(splitQuestion[0]));
        return questionTypeDTO;

    }
}
