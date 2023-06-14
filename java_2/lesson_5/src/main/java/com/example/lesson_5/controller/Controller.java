package com.example.lesson_5.controller;

import com.example.lesson_5.date.MyTimer;
import com.example.lesson_5.template.TemplateAdd;
import com.example.lesson_5.template.TemplateGet;

import com.example.lesson_5.tools.Tools;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class Controller {
    @GetMapping(path = "/user/get/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestGet(@PathVariable String id) {
        String response = "";

        Date date = new Date();
        System.out.println(date + "\t/user/get/" + id);

        TemplateGet templateGet = new TemplateGet();
        response = templateGet.getStrJson(id);

        try {
            //время задержки ответа
            Thread.sleep(MyTimer.timeSleepStub);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + "\t/user/get/" + id + "\tResponse\t" + response);

        HttpHeaders headers = new HttpHeaders();
        headers.add("server","nginx");
        headers.add("set-cookie","IG_JSESSIONID=27B15B6A227A90CF1BFB1453EEE04B21; Path=/; Secure; HttpOnly");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
    @GetMapping(path = "/user/setTimeSleepStub/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleep(@PathVariable String timeSleep) {
        MyTimer.timeSleepStub = Integer.parseInt(timeSleep);
        Date date = new Date();
        return date + "\tnew timeSleep\t" + MyTimer.timeSleepStub;
    }
    @PostMapping(path = "/user/add/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestAdd(@PathVariable String id, @RequestBody String requestBody, @RequestHeader HttpHeaders requestHeaders) {
        String response = "";

        Date date = new Date();
        System.out.println(date + "\t/user/add/" + id);

        String x_mdm_id = requestHeaders.getFirst("X-MDM-ID");
        String x_initiator_service = requestHeaders.getFirst("X-Initiator-Service");

        Tools tools = new Tools(requestBody);
        String fullName = tools.find();

        TemplateAdd templateAdd = new TemplateAdd();
        response = templateAdd.getStrJson(id, fullName);

        try {
            //время задержки ответа
            Thread.sleep(MyTimer.timeSleepStub);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + "\t/user/add/" + id + "\tResponse\t" + response);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-MDM-ID", x_mdm_id);
        headers.add("X-Initiator-Service", x_initiator_service);
        headers.add("server","nginx");
        headers.add("set-cookie","IG_JSESSIONID=27B15B6A227A90CF1BFB1453EEE04B21; Path=/; Secure; HttpOnly");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

}
