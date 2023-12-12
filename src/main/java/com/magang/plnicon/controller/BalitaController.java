package com.magang.plnicon.controller;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.service.BalitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balitas")
public class BalitaController {

    @Autowired
    private BalitaService balitaService;

    @PostMapping("/add")
    public ResponseEntity<Balita> saveBalita(@RequestBody @Valid BalitaDTO balitaDTO) {
        Balita savedBalita = balitaService.saveBalita(balitaDTO);
        return new ResponseEntity<>(savedBalita, HttpStatus.CREATED);
    }
}
