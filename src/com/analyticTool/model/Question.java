package com.analyticTool.model;

import java.time.LocalDate;

public class Question {

    int serviceId;
    int variationId;
    int questionTypeId;
    int categoryId;
    int subCategoryId;
    String responseType;
    LocalDate date;
    int time;

    public Question(int serviceId, int variationId,
                    int questionTypeId, int categoryId,
                    int subCategoryId, String responseType,
                    LocalDate date, int time) {
        this.serviceId = serviceId;
        this.variationId = variationId;
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getVariationId() {
        return variationId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public String getResponseType() {
        return responseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Question{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType='" + responseType + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
