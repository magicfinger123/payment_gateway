package com.cwg.payment.payment_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @GetMapping()
    public String error(){
        return "get error";
    }
    @PostMapping()
    public String postError(){
        return "post error";
    }
}
