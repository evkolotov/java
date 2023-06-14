package com.example.lesson_5.template;

public class TemplateGet {
    public String getStrJson(String id) {

        String strJson = "{" +
            "\"Employee\": {" +
                "\"position\": {" +
                    "\"id\": \""+id+"\"," +
                    "\"fullName\": \"менеджер\"" +
                "}" +
            "}" +
        "}";
        return strJson;
    }

}
