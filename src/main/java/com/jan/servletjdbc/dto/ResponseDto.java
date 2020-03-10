package com.jan.servletjdbc.dto;

public class ResponseDto {
    private Object data;
    private boolean success;
    private String message;

    public ResponseDto(Object data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public ResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
