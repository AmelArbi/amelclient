package com.valtech.amelclient.dto;

import java.util.List;

public class GameDto {
    //iteration
    private  int turn;

    //frames
    private  List<FrameDto> frames;

    //PlayerName
    private  String playerName;

    public GameDto() {
    }

    public GameDto(int turn, List<FrameDto> frames, String playerName) {
        this.turn = turn;
        this.frames = frames;
        this.playerName = playerName;
    }

    public int getTurn() {
        return turn;
    }



    public List<FrameDto> getFrames() {
        return this.frames;
    }


    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "GameDto{" +
                "turn=" + turn +
                ", frames=" + frames +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}





