package com.magang.plnicon.controller;


import com.magang.plnicon.entity.PmtBalita;
import com.magang.plnicon.service.PmtBalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pmtBalita")
public class PmtBalitaController {

    private final PmtBalitaService pmtBalitaService;

    @Autowired
    public PmtBalitaController(PmtBalitaService pmtBalitaService) {
        this.pmtBalitaService = pmtBalitaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<PmtBalita>> getAllPmtBalita() {
        List<PmtBalita> allPmtBalita = pmtBalitaService.getAllPmtBalita();
        if (!allPmtBalita.isEmpty()) {
            return ResponseEntity.ok(allPmtBalita);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PmtBalita tidak ditemukan dalam database");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<PmtBalita> getPmtBalitaById(@PathVariable Integer id) {
        PmtBalita pmtBalita = pmtBalitaService.getPmtBalitaById(id);
        if (pmtBalita != null) {
            return ResponseEntity.ok(pmtBalita);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PmtBalita dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<PmtBalita> createPmtBalita(@RequestBody PmtBalita pmtBalita) {
        PmtBalita createdPmtBalita = pmtBalitaService.createPmtBalita(pmtBalita);
        if (createdPmtBalita != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPmtBalita);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat Pmt. Periksa kembali data yang diberikan.");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<PmtBalita> updatePmtBalita(@PathVariable Integer id, @RequestBody PmtBalita newPmtBalita) {
        try {
            PmtBalita updatedPmtBalita = pmtBalitaService.updatePmtBalita(id, newPmtBalita);
            if (updatedPmtBalita != null) {
                return ResponseEntity.ok(updatedPmtBalita);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PmtBalita dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePmtBalita(@PathVariable Integer id) {
        PmtBalita pmtBalita = pmtBalitaService.getPmtBalitaById(id);
        if (pmtBalita != null) {
            pmtBalitaService.deletePmtBalita(id);
            return ResponseEntity.ok("Pmt dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

