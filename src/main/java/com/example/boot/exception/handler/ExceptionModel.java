package com.example.boot.exception.handler;

import java.util.ArrayList;
import java.util.List;

public class ExceptionModel {

    private final int status;
    private final String message;
    private String stackTrace;
    private List<ValidationError> validationErrorsList;

    public ExceptionModel(int status, String message) {
        this.status = status;
        this.message = message;
    }



    private static class ValidationError{
        private final String field;
        private final String message;

        private ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public List<ValidationError> getValidationErrorsList() {
        return validationErrorsList;
    }

    public void setValidationErrorsList(List<ValidationError> validationErrorsList) {
        this.validationErrorsList = validationErrorsList;
    }

    public void addValidationErrors(ValidationError validationError){
        if(this.validationErrorsList!=null){
            this.validationErrorsList = new ArrayList<>();
        }
        validationErrorsList.add(validationError);
    }
    
}
