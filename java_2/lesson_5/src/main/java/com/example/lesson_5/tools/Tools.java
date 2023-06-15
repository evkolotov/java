package com.example.lesson_5.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    private String request;
    public Tools(String request) {
        this.request = request;
    }
    public String find () {

        Pattern pat = Pattern.compile("\"fullName\":\s*\"(.*?)\"");

        Matcher mat = pat.matcher(request);
        if (mat.find()) {
            return mat.group(1);
        }
        return null;
    }
}
