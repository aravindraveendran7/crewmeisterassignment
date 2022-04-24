package com.crewmeister.testdata;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "set")
@Getter
public class TestData {

    private String crewName;
    private String employeeName;
    private String employeeEmail;
    private String teamName;

}
