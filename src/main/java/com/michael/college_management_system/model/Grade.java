package com.michael.college_management_system.model;

import lombok.Getter;

@Getter
public enum Grade {

    APlus("A+"), A("A"),
    BPlus("B+"), B("B"),
    CPlus("C+"), C("C"),
    DPlus("D+"), D("D"),
    F("F");

    private final String grade;

    Grade(String grade) {
        this.grade = grade;
    }

}
