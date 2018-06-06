package com.keychat.dto.util;

public class ResponseModel {
    private int status;
    private String statusMsg;
    private Object result;

    public ResponseModel(int status, String statusMsg, Object result){
        this.status = status;
        this.statusMsg = statusMsg;
        this.result = result;
    }
}
