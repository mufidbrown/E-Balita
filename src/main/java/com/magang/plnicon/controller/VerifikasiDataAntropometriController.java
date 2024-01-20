package com.magang.plnicon.controller;


import com.magang.plnicon.entity.VerifikasiDataAntropometri;
import com.magang.plnicon.service.VerifikasiDataAntropometriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/verifikasidataantropometri")
public class VerifikasiDataAntropometriController {

    private final VerifikasiDataAntropometriService verifikasiDataAntropometriService;

    @Autowired
    public VerifikasiDataAntropometriController(VerifikasiDataAntropometriService verifikasiDataAntropometriService) {
        this.verifikasiDataAntropometriService = verifikasiDataAntropometriService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllVerifikasiDataAntropometri() {
        List<VerifikasiDataAntropometri> allVerifikasiDataAntropometri = verifikasiDataAntropometriService.getAllVerifikasiDataAntropometri();
        if (!allVerifikasiDataAntropometri.isEmpty()) {
            return ResponseEntity.ok(allVerifikasiDataAntropometri);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada VerifikasiDataAntropometri yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getPenggunaById(@PathVariable Integer id) {
        VerifikasiDataAntropometri verifikasiDataAntropometri = verifikasiDataAntropometriService.getVerifikasiDataAntropometriById(id);
        if (verifikasiDataAntropometri != null) {
            return ResponseEntity.ok(verifikasiDataAntropometri);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VerifikasiDataAntropometri dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createVerifikasiDataAntropometri(@RequestBody VerifikasiDataAntropometri verifikasiDataAntropometri) {
        if (verifikasiDataAntropometri != null) {
            try {
                VerifikasiDataAntropometri createdVerifikasiDataAntropometri = verifikasiDataAntropometriService.createVerifikasiDataAntropometri(verifikasiDataAntropometri);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdVerifikasiDataAntropometri);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat VerifikasiDataAntropometri: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid VerifikasiDataAntropometri input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<VerifikasiDataAntropometri> updateVerifikasiDataAntropometri(@PathVariable Integer id, @RequestBody VerifikasiDataAntropometri newVerifikasiDataAntropometri) {
        try {
            VerifikasiDataAntropometri updatedVerifikasiDataAntropometri = verifikasiDataAntropometriService.updateVerifikasiDataAntropometri(id, newVerifikasiDataAntropometri);
            if (updatedVerifikasiDataAntropometri!= null) {
                return ResponseEntity.ok(updatedVerifikasiDataAntropometri);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "VerifikasiDataAntropometri dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVerifikasiDataAntropometri(@PathVariable Integer id) {
        VerifikasiDataAntropometri verifikasiDataAntropometri = verifikasiDataAntropometriService.getVerifikasiDataAntropometriById(id);
        if (verifikasiDataAntropometri != null) {
            verifikasiDataAntropometriService.deleteVerifikasiDataAntropometri(id);
            return ResponseEntity.ok("VerifikasiDataAntropometri dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
