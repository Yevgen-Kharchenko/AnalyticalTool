package com.analyticTool.model;

public class QuestionTypeDTO {

    int questionTypeId;
    int categoryId;
    int subCategoryId;

    public QuestionTypeDTO() {
        this.questionTypeId = 0;
        this.categoryId = 0;
        this.subCategoryId = 0;
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

    @Override
    public String toString() {
        return "QuestionTypeDTO{" +
                "questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                '}';
    }
}
