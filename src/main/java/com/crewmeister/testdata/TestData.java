package com.crewmeister.testdata;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class TestData {

    private String username;
    private String password;
    private String crewName;
    private String employeeName;
    private String employeeEmail;
    private String teamName;

}
