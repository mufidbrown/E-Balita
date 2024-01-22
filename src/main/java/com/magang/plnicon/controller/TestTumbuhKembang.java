package com.magang.plnicon.controller;

import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.service.tumbuhkembang.TumbuhKembangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTumbuhKembang {

    @Autowired
    private TumbuhKembangService tumbuhKembangService;

    @GetMapping("/testtumbuhkembang")
    public BaseResponse<?> testtumbuhkembang() {
        return tumbuhKembangService.testtumbuhkembang();
    }

//    @GetMapping("/testtumbuhkembang/v1/{id}")
//    public BaseResponse<?> testParameterTumbuhKembang(@PathVariable Integer id){
//        return tumbuhKembangService.testParameterTumbuhKembang(id);
//    }

    @GetMapping("/testtumbuhkembang/v1/{id}")
    public BaseResponse<?>testParameterTumbuhKembang(@PathVariable Integer id){
        return tumbuhKembangService.testParameterTumbuhKembang(id);
    }

}
