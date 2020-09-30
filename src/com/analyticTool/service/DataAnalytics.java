package com.analyticTool.service;

import com.analyticTool.model.Query;
import com.analyticTool.model.Question;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalytics {

    public List<Question> filterData(List<Question> questionList, Query query) {
        Predicate<Question> serviceId;
        Predicate<Question> variationId;
        Predicate<Question> questionTypeId;
        Predicate<Question> categoryId;
        Predicate<Question> subCategoryId;
        Predicate<Question> responseType;
        Predicate<Question> compareDate = (Question t) -> t.getDate().compareTo(query.getDateFrom()) >= 0 && t.getDate().compareTo(query.getDateTo()) <= 0;

        if (!query.getResponseType().equals("*")) {
            responseType = (Question t) -> t.getResponseType().equals(query.getResponseType());
        } else {
            responseType = (Question t) -> !t.getResponseType().equals(query.getResponseType());
        }

        if (query.getServiceId() > 0) {
            serviceId = (Question t) -> t.getServiceId() == (query.getServiceId());
        } else {
            serviceId = (Question t) -> t.getServiceId() >= (query.getServiceId());
        }

        if (query.getVariationId() > 0) {
            variationId = (Question t) -> t.getVariationId() == (query.getVariationId());
        } else {
            variationId = (Question t) -> t.getVariationId() >= (query.getVariationId());
        }

        if (query.getQuestionTypeId() > 0) {
            questionTypeId = (Question t) -> t.getQuestionTypeId() == (query.getQuestionTypeId());
        } else {
            questionTypeId = (Question t) -> t.getQuestionTypeId() >= (query.getQuestionTypeId());
        }

        if (query.getCategoryId() > 0) {
            categoryId = (Question t) -> t.getCategoryId() == (query.getCategoryId());
        } else {
            categoryId = (Question t) -> t.getCategoryId() >= (query.getCategoryId());
        }

        if (query.getSubCategoryId() > 0) {
            subCategoryId = (Question t) -> t.getSubCategoryId() == (query.getSubCategoryId());
        } else {
            subCategoryId = (Question t) -> t.getSubCategoryId() >= (query.getSubCategoryId());
        }

        Stream<Question> questionStream = questionList.stream()
                .filter(serviceId)
                .filter(variationId)
                .filter(questionTypeId)
                .filter(categoryId)
                .filter(subCategoryId)
                .filter(responseType)
                .filter(compareDate);

        return questionStream.collect(Collectors.toList());
    }
}
