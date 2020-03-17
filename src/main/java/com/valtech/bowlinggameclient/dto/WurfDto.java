package com.valtech.bowlinggameclient.dto;

import java.util.Objects;

public class WurfDto {

    private int zahl;

    public WurfDto() {
    }

    public WurfDto(int zahl) {
        this.zahl = zahl;
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        WurfDto wurfDto = (WurfDto) o;
        return zahl == wurfDto.zahl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zahl);
    }
}
