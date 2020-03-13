package com.valtech.bowlinggameclient.dto;

public class PlayerNameDto {

    private String name;

    public PlayerNameDto() {
    }

    public PlayerNameDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
