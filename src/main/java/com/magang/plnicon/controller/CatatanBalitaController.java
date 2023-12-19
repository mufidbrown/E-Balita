//package com.magang.plnicon.controller;
//
//
//import com.magang.plnicon.entity.CatatanBalita;
//import com.magang.plnicon.service.CatatanBalitaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/balita-records")
//public class CatatanBalitaController {
//
//    private final CatatanBalitaService catatanBalitaService;
//
//    @Autowired
//    public CatatanBalitaController(CatatanBalitaService catatanBalitaService) {
//        this.catatanBalitaService = catatanBalitaService;
//    }
//
//    @PostMapping
//    public ResponseEntity<CatatanBalita> createCatatanBalita(@RequestBody CatatanBalita catatanBalita) {
//        CatatanBalita createdBalita = catatanBalitaService.saveCatatanBalita(catatanBalita);
//        return new ResponseEntity<>(catatanBalita, HttpStatus.CREATED);
//    }
//}