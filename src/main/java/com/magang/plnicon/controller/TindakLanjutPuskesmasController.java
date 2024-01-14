package com.magang.plnicon.controller;


import com.magang.plnicon.entity.TindakLanjutPuskesmas;
import com.magang.plnicon.service.TindakLanjutPuskesmasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tindaklanjut")
public class TindakLanjutPuskesmasController {

    private final TindakLanjutPuskesmasService tindakLanjutPuskesmasService;

    @Autowired
    public TindakLanjutPuskesmasController(TindakLanjutPuskesmasService tindakLanjutPuskesmasService) {
        this.tindakLanjutPuskesmasService = tindakLanjutPuskesmasService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTindakLanjutPuskesmas() {
        List<TindakLanjutPuskesmas> allTindakLanjutPuskesmas = tindakLanjutPuskesmasService.getAllTindakLanjutPuskesmas();
        if (!allTindakLanjutPuskesmas.isEmpty()) {
            return ResponseEntity.ok(allTindakLanjutPuskesmas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada TindakLanjutPuskesmas yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getTindakLanjutPuskesmasById(@PathVariable Integer id) {
        TindakLanjutPuskesmas tindakLanjutPuskesmas = tindakLanjutPuskesmasService.getTindakLanjutPuskesmasById(id);
        if (tindakLanjutPuskesmas != null) {
            return ResponseEntity.ok(tindakLanjutPuskesmas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TindakLanjutPuskesmas dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createTindakLanjutPuskesmas(@RequestBody TindakLanjutPuskesmas tindakLanjutPuskesmas) {
        if (tindakLanjutPuskesmas != null) {
            try {
                TindakLanjutPuskesmas createdTindakLanjutPuskesmas = tindakLanjutPuskesmasService.createTindakLanjutPuskesmas(tindakLanjutPuskesmas);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdTindakLanjutPuskesmas);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat pengguna: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Pengguna input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<TindakLanjutPuskesmas> updateTindakLanjutPuskesmas(@PathVariable Integer id, @RequestBody TindakLanjutPuskesmas newTindakLanjutPuskesmas) {
        try {
            TindakLanjutPuskesmas updatedTindakLanjutPuskesmas = tindakLanjutPuskesmasService.updateTindakLanjutPuskesmas(id, newTindakLanjutPuskesmas);
            if (updatedTindakLanjutPuskesmas!= null) {
                return ResponseEntity.ok(updatedTindakLanjutPuskesmas);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TindakLanjutPuskesmas dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTindakLanjutPuskesmas(@PathVariable Integer id) {
        TindakLanjutPuskesmas tindakLanjutPuskesmas = tindakLanjutPuskesmasService.getTindakLanjutPuskesmasById(id);
        if (tindakLanjutPuskesmas != null) {
            tindakLanjutPuskesmasService.deleteTindakLanjutPuskesmas(id);
            return ResponseEntity.ok("TindakLanjutPuskesmas dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
