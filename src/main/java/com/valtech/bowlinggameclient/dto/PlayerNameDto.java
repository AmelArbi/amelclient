package com.valtech.bowlinggameclient.dto;

import java.util.Objects;

public class PlayerNameDto{

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlayerNameDto that = (PlayerNameDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
