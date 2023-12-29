package com.magang.plnicon.controller;

import com.magang.plnicon.entity.Posyandu;
import com.magang.plnicon.service.PosyanduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posyandu")
public class PosyanduController {

    private final PosyanduService posyanduService;

    @Autowired
    public PosyanduController(PosyanduService posyanduService) {
        this.posyanduService = posyanduService;
    }

    @GetMapping
    public ResponseEntity<List<Posyandu>> getAllPosyandu() {
        List<Posyandu> posyandus = posyanduService.getAllPosyandu();
        return new ResponseEntity<>(posyandus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posyandu> getPosyanduById(@PathVariable Integer id) {
        Posyandu posyandu = posyanduService.getPosyanduById(id);
        if (posyandu != null) {
            return new ResponseEntity<>(posyandu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Posyandu> createPosyandu(@RequestBody Posyandu posyandu) {
        Posyandu createdPosyandu = posyanduService.createPosyandu(posyandu);
        return new ResponseEntity<>(createdPosyandu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posyandu> updatePosyandu(@PathVariable Integer id, @RequestBody Posyandu posyandu) {
        Posyandu updatedPosyandu = posyanduService.updatePosyandu(id, posyandu);
        if (updatedPosyandu != null) {
            return new ResponseEntity<>(updatedPosyandu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosyandu(@PathVariable Integer id) {
        posyanduService.deletePosyandu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}