package com.magang.plnicon.controller;

import com.magang.plnicon.entity.Pengguna;
import com.magang.plnicon.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pengguna")
public class PenggunaController {

    private final PenggunaService penggunaService;

    @Autowired
    public PenggunaController(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pengguna>> getAllPengguna() {
        List<Pengguna> allPengguna = penggunaService.getAllPengguna();
        if (!allPengguna.isEmpty()) {
            return ResponseEntity.ok(allPengguna);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPenggunaById(@PathVariable Integer id) {
        Pengguna pengguna = penggunaService.getPenggunaById(id);
        if (pengguna != null) {
            return ResponseEntity.ok(pengguna);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pengguna dengan ID " + id + " tidak ditemukan");
        }
    }



    @PostMapping("/create")
    public ResponseEntity<Pengguna> createPengguna(@RequestBody Pengguna pengguna) {
        try {
            Pengguna createdPengguna = penggunaService.createPengguna(pengguna);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPengguna);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pengguna> updatePengguna(@PathVariable Integer id, @RequestBody Pengguna newPengguna) {
        try {
            Pengguna updatedPengguna = penggunaService.updatePengguna(id, newPengguna);
            if (updatedPengguna!= null) {
                return ResponseEntity.ok(updatedPengguna);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengguna dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePengguna(@PathVariable Integer id) {
        Pengguna pengguna = penggunaService.getPenggunaById(id);
        if (pengguna != null) {
            penggunaService.deletePengguna(id);
            return ResponseEntity.ok("Pmt dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}


//    @GetMapping("/{id}")
//    public ResponseEntity<Pengguna> getPenggunaById(@PathVariable Integer id) {
//        Pengguna pengguna = penggunaService.getPenggunaById(id);
//        if (pengguna != null) {
//            return ResponseEntity.ok(pengguna);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }



//    @PutMapping("/{id}")
//    public ResponseEntity<Pengguna> updatePengguna(@PathVariable Integer id, @RequestBody Pengguna pengguna) {
//        Pengguna updatedPengguna = penggunaService.updatePengguna(id, pengguna);
//        if (updatedPengguna != null) {
//            return ResponseEntity.ok(updatedPengguna);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }