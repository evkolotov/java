package com.example.lesson_5.template;

public class TemplateGet {
    public String getStrJson(String id) {

        String strJson = String.format("{" +
            "\"Employee\": {" +
                "\"position\": {" +
                    "\"id\": \"%s\"," +
                    "\"fullName\": \"менеджер\"" +
                "}" +
            "}" +
        "}", id);
        return strJson;
    }

}
