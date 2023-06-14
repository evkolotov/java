package com.example.lesson_5.template;

public class TemplateAdd {
    public String getStrJson(String id, String fullName) {

        String strJson = "{" +
                "\"Employee\": {" +
                "\"position\": {" +
                "\"id\": \""+id+"\"," +
                "\"fullName\": \""+fullName+"\"" +
                "}" +
                "}" +
                "}";
        return strJson;
    }
}
