package com.example.lesson_5.template;

public class TemplateAdd {
    public String getStrJson(String id, String fullName) {

        String strJson = String.format("{" +
                "\"Employee\": {" +
                "\"position\": {" +
                "\"id\": \"%s\"," +
                "\"fullName\": \"%s\"" +
                "}" +
                "}" +
                "}", id, fullName);
        return strJson;
    }
}
