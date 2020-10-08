package com.analyticTool.model;

import java.time.LocalDate;

public class Query {

    int serviceId;
    int variationId;
    int questionTypeId;
    int categoryId;
    int subCategoryId;
    String responseType;
    LocalDate dateFrom;
    LocalDate dateTo;

    public Query(int serviceId, int variationId,
                 int questionTypeId, int categoryId,
                 int subCategoryId, String responseType,
                 LocalDate dateFrom, LocalDate dateTo) {
        this.serviceId = serviceId;
        this.variationId = variationId;
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return "Query{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType='" + responseType + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
