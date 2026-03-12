package com.springbootpractice.exception;

import java.time.LocalDate;

public class ExceptionResponse {

    private LocalDate timeStamp;
    private String message;
    private String httpCodeMessage;
    private String details;

    public ExceptionResponse(String details, LocalDate timeStamp, String message, String httpCodeMessage) {
        this.details = details;
        this.timeStamp = timeStamp;
        this.message = message;
        this.httpCodeMessage = httpCodeMessage;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(String httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
