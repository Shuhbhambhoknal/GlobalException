package com.springbootpractice.exception;

import java.time.LocalDate;

public class ExceptionResponse {

    private LocalDate timeStamp;
    private String message;
    private String httpCodeMsg;
    private String details;

    public ExceptionResponse(String details, LocalDate timeStamp, String message, String httpCodeMsg) {
        this.details = details;
        this.timeStamp = timeStamp;
        this.message = message;
        this.httpCodeMsg = httpCodeMsg;
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

    public String getHttpCodeMsg() {
        return httpCodeMsg;
    }

    public void setHttpCodeMsg(String httpCodeMsg) {
        this.httpCodeMsg = httpCodeMsg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
