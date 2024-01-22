package com.magang.plnicon.controller;

import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.service.vitamin.VitaminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestVitamin {

    @Autowired
    private VitaminService vitaminService;

    @GetMapping("/test")
    public BaseResponse<?> test() {
        return vitaminService.test();
    }

    @GetMapping("/test/v1/{id}")
    public BaseResponse<?> testParameter(@PathVariable Integer id){
        return vitaminService.testParameter(id);
    }
}
