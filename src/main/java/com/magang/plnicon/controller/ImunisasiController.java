package com.magang.plnicon.controller;


import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.entity.Imunisasi;
import com.magang.plnicon.service.ImunisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/imunisasi")
public class ImunisasiController {

    private final ImunisasiService imunisasiService;

    @Autowired
    public ImunisasiController(ImunisasiService imunisasiService) {
        this.imunisasiService = imunisasiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Imunisasi>> getAllPmt() {
        List<Imunisasi> allImunisasi = imunisasiService.getAllImunisasi();
        if (!allImunisasi.isEmpty()) {
            return ResponseEntity.ok(allImunisasi);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imunisasi tidak ditemukan dalam database");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Imunisasi> getImunisasiById(@PathVariable Integer id) {
        Imunisasi imunisasi = imunisasiService.getImunisasiById(id);
        if (imunisasi != null) {
            return ResponseEntity.ok(imunisasi);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imunisasi dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<Imunisasi> createImunisasi(@RequestBody Imunisasi imunisasi) {
        Imunisasi createdImunisasi = imunisasiService.createImunisasi(imunisasi);
        if (createdImunisasi != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdImunisasi);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat Imunisasi. Periksa kembali data yang diberikan.");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Imunisasi> updateImunisasi(@PathVariable Integer id, @RequestBody Imunisasi newImunisasi) {
        try {
            Imunisasi updatedImunisasi = imunisasiService.updateImunisasi(id, newImunisasi);
            if (updatedImunisasi != null) {
                return ResponseEntity.ok(updatedImunisasi);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imunisasi dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImunisasi(@PathVariable Integer id) {
        Imunisasi imunisasi = imunisasiService.getImunisasiById(id);
        if (imunisasi != null) {
            imunisasiService.deleteImunisasi(id);
            return ResponseEntity.ok("Imunisasi dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /*
            -----------------------BASERESPONSE------------------------
*/


    @GetMapping("/vitamin/v1")
    public ResponseEntity<BaseResponse<List<Imunisasi>>> getAllImunisasi2() {
        List<Imunisasi> imunisasi = imunisasiService.getAllImunisasi();
        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua Vitamin", imunisasi));

    }

    @GetMapping("/vitamin/v1/{id}")
    public ResponseEntity<BaseResponse<Imunisasi>> getImunisasiById2(@PathVariable("id") Integer id) {
        Imunisasi imunisasi = imunisasiService.getImunisasiById(id);
        if (imunisasi != null) {
            return ResponseEntity.ok(BaseResponse.ok("Vitamin Ditemukan", imunisasi));
        } else {
            return ResponseEntity.ok(BaseResponse.error("Vitamin Tidak Ditemukan"));
        }
    }


}