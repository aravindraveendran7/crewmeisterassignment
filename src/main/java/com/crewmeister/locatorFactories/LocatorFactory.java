package com.crewmeister.locatorFactories;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class LocatorFactory {

    private LocatorFactory(){}

    private static final Map<String, Function<String,By>> MAP =new HashMap<>();

    private static final Function<String,By>XPATH= By::xpath;
    private static final Function<String,By>ID= By::xpath;
    private static final Function<String,By>NAME= By::xpath;

    static {
        MAP.put("xpath",XPATH);
        MAP.put("id",ID);
        MAP.put("name",NAME);
    }

    public static By getLocator(String locator,String value){
        return MAP.get(locator).apply(value);
    }



}
