package com.magang.plnicon.controller;

import com.magang.plnicon.entity.LaporanBalita;
import com.magang.plnicon.service.LaporanBalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/v1/laporan")
public class LaporanBalitaController {

    private final LaporanBalitaService laporanBalitaService;

    @Autowired
    public LaporanBalitaController(LaporanBalitaService laporanBalitaService) {
        this.laporanBalitaService = laporanBalitaService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllLaporanBalita() {
        List<LaporanBalita> allLaporanBalita = laporanBalitaService.getAllLaporanBalita();
        if (!allLaporanBalita.isEmpty()) {
            return ResponseEntity.ok(allLaporanBalita);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada LaporanBalita yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getLaporanBalitaById(@PathVariable Integer id) {
        LaporanBalita laporanBalita = laporanBalitaService.getLaporanBalitaById(id);
        if (laporanBalita != null) {
            return ResponseEntity.ok(laporanBalita);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LaporanBalita dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createLaporanBalita(@RequestBody LaporanBalita laporanBalita) {
        if (laporanBalita != null) {
            try {
                LaporanBalita createdLaporanBalita = laporanBalitaService.createLaporanBalita(laporanBalita);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdLaporanBalita);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat LaporanBalita: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid LaporanBalita input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<LaporanBalita> updateLaporanBalita(@PathVariable Integer id, @RequestBody LaporanBalita newLaporanBalita) {
        try {
            LaporanBalita updatedLaporanBalita = laporanBalitaService.updateLaporanBalita(id, newLaporanBalita);
            if (updatedLaporanBalita!= null) {
                return ResponseEntity.ok(updatedLaporanBalita);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "LaporanBalita dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLaporanBalita(@PathVariable Integer id) {
        LaporanBalita laporanBalita = laporanBalitaService.getLaporanBalitaById(id);
        if (laporanBalita != null) {
            laporanBalitaService.deleteLaporanBalita(id);
            return ResponseEntity.ok("LaporanBalita dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}