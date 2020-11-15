package com.paysend.test.controller;

import com.paysend.test.dto.Request;
import com.paysend.test.dto.Response;
import com.paysend.test.entity.User;
import com.paysend.test.service.PaySendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaySendController {

    @Autowired
    private PaySendService paySendService;

    @PostMapping(value="/register", produces = MediaType.APPLICATION_XML_VALUE,
            consumes = MediaType.APPLICATION_XML_VALUE
    )
    public ResponseEntity<Response> register(@RequestBody final Request request) {

        System.out.printf("Request %s", request);

        final User user = new User(new Long(-1),
                request.getLogin().getText(),
                request.getLogin().getText(),
                null);

        paySendService.registerUser(user);

        return new ResponseEntity<Response>(
                new Response("register", "name"), HttpStatus.OK);
    }

    @PostMapping(value="/balance", produces=MediaType.APPLICATION_XML_VALUE)
    public Response getBalance(@RequestBody final Request request) {

        return new Response();
    }
}
