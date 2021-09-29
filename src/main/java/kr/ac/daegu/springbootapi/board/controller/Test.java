package kr.ac.daegu.springbootapi.board.controller;

import lombok.Builder;

import java.util.List;

public class Test<T> {
    private String status;
    private List<T> data;

    @Builder
    public Test(String status, List<T> data) {
        this.status = status;
        this.data = data;
    }
}
