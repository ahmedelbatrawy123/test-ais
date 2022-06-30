package com.batrawy.ais.controller;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "mock-controller")
@AllArgsConstructor
@RestController
@RequestMapping("mock")
public class MockController {


    @PostMapping("/irrigate")
    public String mocK() {
        return "success";
    }



}
