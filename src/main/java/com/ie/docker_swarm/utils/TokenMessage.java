package com.ie.docker_swarm.utils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class TokenMessage<T> {
//    private int code;
    private T data;

    public TokenMessage() {
    }
//    public TokenMessage(Integer code, T token) {
//        this.code = code;
//        this.token = token;
//
//    }


    public TokenMessage(T token) {
        this.data = token;
    }

//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }

    public T getData() {
        return data;
    }

    public void setData(T token) {
        this.data = token;
    }
}
