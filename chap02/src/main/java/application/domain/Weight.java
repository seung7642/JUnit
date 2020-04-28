package application.domain;

import lombok.Getter;

public enum  Weight {

    MustMatch(Integer.MAX_VALUE),
    VeryImportant(5000),
    Important(1000),
    WouldPrefer(100),
    DontCare(0);

    @Getter
    private int value;

    Weight(int value) {
        this.value = value;
    }
}