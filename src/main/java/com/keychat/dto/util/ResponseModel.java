package com.keychat.dto.util;

public class ResponseModel {
    private int status;
    private String statusMsg;
    private String result;

    public ResponseModel(int status, String statusMsg, String result){
        this.status = status;
        this.statusMsg = statusMsg;
        this.result = result;
    }
}
