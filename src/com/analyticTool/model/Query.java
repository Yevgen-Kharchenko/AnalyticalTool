package com.analyticTool.model;

import java.time.LocalDate;
import java.util.Date;

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

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVariationId() {
        return variationId;
    }

    public void setVariationId(int variationId) {
        this.variationId = variationId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
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
