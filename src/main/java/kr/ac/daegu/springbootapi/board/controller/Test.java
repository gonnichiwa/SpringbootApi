package kr.ac.daegu.springbootapi.board.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Test<T> {
    private String status;
    private T data;

    public Test(String status, T data) {
        this.status = status;
        this.data = data;
    }
}
