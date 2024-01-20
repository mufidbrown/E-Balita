package com.magang.plnicon.controller;


import com.magang.plnicon.entity.Antropometri;
import com.magang.plnicon.service.AntropometriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/antropometri")
public class AntropometriController {

    private final AntropometriService antropometriService;

    @Autowired
    public AntropometriController(AntropometriService antropometriService) {
        this.antropometriService = antropometriService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAntropometri() {
        List<Antropometri> allAntropometri = antropometriService.getAllAntropometri();
        if (!allAntropometri.isEmpty()) {
            return ResponseEntity.ok(allAntropometri);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada Antropometri yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getAntropometriById(@PathVariable Integer id) {
        Antropometri antropometri = antropometriService.getAntropometriById(id);
        if (antropometri != null) {
            return ResponseEntity.ok(antropometri);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Antropometri dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createAntropometri(@RequestBody Antropometri antropometri) {
        if (antropometri != null) {
            try {
                Antropometri createdAntropometri = antropometriService.createAntropometri(antropometri);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdAntropometri);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat Antropometri: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Antropometri input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Antropometri> updateAntropometri(@PathVariable Integer id, @RequestBody Antropometri newAntropometri) {
        try {
            Antropometri updatedAntropometri = antropometriService.updateAntropometri(id, newAntropometri);
            if (updatedAntropometri!= null) {
                return ResponseEntity.ok(updatedAntropometri);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Antropometri dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAntropometri(@PathVariable Integer id) {
        Antropometri antropometri = antropometriService.getAntropometriById(id);
        if (antropometri != null) {
            antropometriService.deleteAntropometri(id);
            return ResponseEntity.ok("Antropometri dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
