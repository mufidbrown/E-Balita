package com.magang.plnicon.controller;


import com.magang.plnicon.entity.Pmt;
import com.magang.plnicon.service.PmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pmt")
public class PmtController {

    private final PmtService pmtService;

    @Autowired
    public PmtController(PmtService pmtService) {
        this.pmtService = pmtService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pmt>> getAllPmt() {
        List<Pmt> allPmt = pmtService.getAllPmt();
        if (!allPmt.isEmpty()) {
            return ResponseEntity.ok(allPmt);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pmt tidak ditemukan dalam database");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pmt> getPmtById(@PathVariable Integer id) {
        Pmt pmt = pmtService.getPmtById(id);
        if (pmt != null) {
            return ResponseEntity.ok(pmt);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pmt dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<Pmt> createPmt(@RequestBody Pmt pmt) {
        Pmt createdPmt = pmtService.createPmt(pmt);
        if (createdPmt != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPmt);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat Pmt. Periksa kembali data yang diberikan.");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Pmt> updatePmt(@PathVariable Integer id, @RequestBody Pmt newPmt) {
        try {
            Pmt updatedPmt = pmtService.updatePmt(id, newPmt);
            if (updatedPmt != null) {
                return ResponseEntity.ok(updatedPmt);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pmt dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePmt(@PathVariable Integer id) {
        Pmt pmt = pmtService.getPmtById(id);
        if (pmt != null) {
            pmtService.deletePmt(id);
            return ResponseEntity.ok("Pmt dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}




//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deletePmt(@PathVariable Integer id) {
//        try {
//            pmtService.deletePmt(id);
//            return ResponseEntity.ok("Pmt dengan ID " + id + " berhasil dihapus");
//        } catch (EntityNotFoundException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//        }
//    }

