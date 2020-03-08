package com.codepirates.securitydesk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class LateNightConeyanceModel extends Employee {

    private LocalDate checkInTime;
    private LocalDate checkOutTime;

    public LocalDate getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDate getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDate checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
