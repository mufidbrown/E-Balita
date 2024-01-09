package com.magang.plnicon.controller;


import com.magang.plnicon.entity.Dokumen;
import com.magang.plnicon.service.DokumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/dokumen")
public class DokumenController {

    private final DokumenService dokumenService;

    @Autowired
    public DokumenController(DokumenService dokumenService) {
        this.dokumenService = dokumenService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDokumen() {
        List<Dokumen> allDokumen = dokumenService.getAllDokumen();
        if (!allDokumen.isEmpty()) {
            return ResponseEntity.ok(allDokumen);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada Dokumen yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getDokumenById(@PathVariable Integer id) {
        Dokumen dokumen = dokumenService.getDokumenById(id);
        if (dokumen != null) {
            return ResponseEntity.ok(dokumen);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dokumen dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createDokumen(@RequestBody Dokumen dokumen) {
        if (dokumen != null) {
            try {
                Dokumen createdDokumen = dokumenService.createDokumen(dokumen);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdDokumen);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat Dokumen: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Dokumen input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Dokumen> updateDokumen(@PathVariable Integer id, @RequestBody Dokumen newDokumen) {
        try {
            Dokumen updatedDokumen = dokumenService.updateDokumen(id, newDokumen);
            if (updatedDokumen!= null) {
                return ResponseEntity.ok(updatedDokumen);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dokumen dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDokumen(@PathVariable Integer id) {
        Dokumen dokumen = dokumenService.getDokumenById(id);
        if (dokumen != null) {
            dokumenService.deleteDokumen(id);
            return ResponseEntity.ok("Dokumen dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
