package com.analyticTool.model;

import java.time.LocalDate;

public class DateDTO {

    LocalDate dateFrom;
    LocalDate dateTo;

    public DateDTO() {
        this.dateFrom = LocalDate.now();
        this.dateTo = LocalDate.now();
    }

    public DateDTO(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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
}
