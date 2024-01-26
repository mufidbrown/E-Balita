package com.magang.plnicon.controller;


import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.service.BalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/balita")
public class BalitaController {

    private final BalitaService balitaService;

    @Autowired
    public BalitaController(BalitaService balitaService) {
        this.balitaService = balitaService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBalita() {
        List<Balita> allBalita = balitaService.getAllBalita();
        if (!allBalita.isEmpty()) {
            return ResponseEntity.ok(allBalita);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada Balita yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getBalitaById(@PathVariable Integer id) {
        Balita balita = balitaService.getBalitaById(id);
        if (balita != null) {
            return ResponseEntity.ok(balita);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Balita dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createBalita(@RequestBody Balita balita) {
        if (balita != null) {
            try {
                Balita createdBalita = balitaService.createBalita(balita);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdBalita);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat Balita: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Balita input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Balita> updateBalita(@PathVariable Integer id, @RequestBody Balita newBalita) {
        try {
            Balita updatedBalita = balitaService.updateBalita(id, newBalita);
            if (updatedBalita!= null) {
                return ResponseEntity.ok(updatedBalita);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Balita dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBalita(@PathVariable Integer id) {
        Balita balita = balitaService.getBalitaById(id);
        if (balita != null) {
            balitaService.deleteBalita(id);
            return ResponseEntity.ok("Balita dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /*
            -----------------------BASERESPONSE------------------------
*/


    @GetMapping("/vitamin/v1")
    public ResponseEntity<BaseResponse<List<Balita>>> getAllBalita2() {
        List<Balita> balita = balitaService.getAllBalita();
        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua Balita", balita));

    }

    @GetMapping("/vitamin/v1/{id}")
    public ResponseEntity<BaseResponse<Balita>> getBalitaById2(@PathVariable("id") Integer id) {
        Balita balita = balitaService.getBalitaById(id);
        if (balita != null) {
            return ResponseEntity.ok(BaseResponse.ok("Balita Ditemukan", balita));
        } else {
            return ResponseEntity.ok(BaseResponse.error("Balita Tidak Ditemukan"));
        }
    }

}
