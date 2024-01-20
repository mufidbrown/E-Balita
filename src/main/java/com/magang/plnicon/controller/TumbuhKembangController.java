package com.magang.plnicon.controller;


import com.magang.plnicon.entity.TumbuhKembang;
import com.magang.plnicon.service.TumbuhKembangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tumbuhKembang/auth")
public class TumbuhKembangController {

    private final TumbuhKembangService tumbuhKembangService;

    @Autowired
    public TumbuhKembangController(TumbuhKembangService tumbuhKembangService) {
        this.tumbuhKembangService = tumbuhKembangService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTumbuhKembang() {
        List<TumbuhKembang> allTumbuhKembang = tumbuhKembangService.getAllTumbuhKembang();
        if (!allTumbuhKembang.isEmpty()) {
            return ResponseEntity.ok(allTumbuhKembang);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada Tumbuh Kembang yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getTumbuhKembangById(@PathVariable Integer id) {
        TumbuhKembang tumbuhKembang = tumbuhKembangService.getTumbuhKembangById(id);
        if (tumbuhKembang != null) {
            return ResponseEntity.ok(tumbuhKembang);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tumbuh Kembang dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createTumbuhKembang(@RequestBody TumbuhKembang tumbuhKembang) {
        if (tumbuhKembang != null) {
            try {
                TumbuhKembang createdTumbuhKembang = tumbuhKembangService.createTumbuhKembang(tumbuhKembang);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdTumbuhKembang);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat TKa: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid TK input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<TumbuhKembang> updateTumbuhKembang(@PathVariable Integer id, @RequestBody TumbuhKembang newTumbuhKembang) {
        try {
            TumbuhKembang updatedTumbuhKembang = tumbuhKembangService.updateTumbuhKembang(id, newTumbuhKembang);
            if (updatedTumbuhKembang!= null) {
                return ResponseEntity.ok(updatedTumbuhKembang);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengguna dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTumbuhKembang(@PathVariable Integer id) {
        TumbuhKembang tumbuhKembang = tumbuhKembangService.getTumbuhKembangById(id);
        if (tumbuhKembang != null) {
            tumbuhKembangService.deleteTumbuhKembang(id);
            return ResponseEntity.ok("PmtBalita dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
