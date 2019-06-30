package com.ie.docker_swarm.utils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect
public class ResponseMessage<T> {
    private int code;
    private T data;

    public ResponseMessage() {
    }
    public ResponseMessage(Integer code, T data) {
        this.code = code;
        this.data = data;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
