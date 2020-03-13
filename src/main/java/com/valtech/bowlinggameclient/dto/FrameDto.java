package com.valtech.bowlinggameclient.dto;

import java.util.List;

public class FrameDto {


    private  List<Integer> throwList;

    private  int score;

    public FrameDto(List<Integer> throwList, int score) {
        this.throwList = throwList;
        this.score = score;
    }

    public FrameDto() {
    }

    public int getScore() {
        return score;
    }

    public List<Integer> getThrowList() {
        return throwList;
    }

    @Override
    public String toString() {
        return "FrameDto{" +
                "throwList=" + throwList +
                ", score=" + score +
                '}';
    }
}
