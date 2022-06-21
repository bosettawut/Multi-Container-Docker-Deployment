package com.example.backend.user.exception;

public class ErrorDetail {
    private String error;

    public ErrorDetail() {
    }

    public ErrorDetail(String error, String description) {
        super();
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
