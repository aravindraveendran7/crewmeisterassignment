package com.crewmeister.constants;

import lombok.Getter;


public final class FrameworkConstants {

    private FrameworkConstants(){}

    @Getter private static final String REPORT_PATH=System.getProperty("user.dir")+"/index.html";


}
