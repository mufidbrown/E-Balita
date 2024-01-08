package com.magang.plnicon.controller;

import com.magang.plnicon.entity.master.Puskesmas;
import com.magang.plnicon.service.PuskesmasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puskesmas")
public class PuskesmasController {

    private final PuskesmasService puskesmasService;

    @Autowired
    public PuskesmasController(PuskesmasService puskesmasService) {
        this.puskesmasService = puskesmasService;
    }

    @GetMapping
    public ResponseEntity<List<Puskesmas>> getAllPuskesmas() {
        List<Puskesmas> allPuskesmas = puskesmasService.getAllPuskesmas();
        return new ResponseEntity<>(allPuskesmas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puskesmas> getPuskesmasById(@PathVariable Integer id) {
        Puskesmas puskesmas = puskesmasService.getPuskesmasById(id);
        return new ResponseEntity<>(puskesmas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Puskesmas> createPuskesmas(@RequestBody Puskesmas puskesmas) {
        Puskesmas createdPuskesmas = puskesmasService.createPuskesmas(puskesmas);
        return new ResponseEntity<>(createdPuskesmas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Puskesmas> updatePuskesmas(@PathVariable Integer id, @RequestBody Puskesmas newPuskesmas) {
        Puskesmas updatedPuskesmas = puskesmasService.updatePuskesmas(id, newPuskesmas);
        return new ResponseEntity<>(updatedPuskesmas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuskesmas(@PathVariable Integer id) {
        puskesmasService.deletePuskesmas(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
