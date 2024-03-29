package com.magang.plnicon.controller;


import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.entity.Vitamin;
import com.magang.plnicon.service.vitamin.VitaminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vitamin")
public class VitaminController {

    @Autowired
    private final VitaminService vitaminService;

    @Autowired
    public VitaminController(VitaminService vitaminService) {
        this.vitaminService = vitaminService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_KADER')")
    public ResponseEntity<List<Vitamin>> getAllVitamin() {
        List<Vitamin> allVitamin = vitaminService.getAllVitamin();
        if (!allVitamin.isEmpty()) {
            return ResponseEntity.ok(allVitamin);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vitamin tidak ditemukan dalam database");
        }
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_KADER')")
    public ResponseEntity<Vitamin> getVitaminById(@PathVariable Integer id) {
        Vitamin vitamin = vitaminService.getVitaminById(id);
        if (vitamin != null) {
            return ResponseEntity.ok(vitamin);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vitamin dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_KADER')")
    public ResponseEntity<Vitamin> createPmt(@RequestBody Vitamin vitamin) {
        Vitamin createdVitamin = vitaminService.createVitamin(vitamin);
        if (createdVitamin != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdVitamin);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gagal membuat Vitamin. Periksa kembali data yang diberikan.");
        }
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_KADER')")
    public ResponseEntity<Vitamin> updateVitamin(@PathVariable Integer id, @RequestBody Vitamin newVitamin) {
        try {
            Vitamin updatedVitamin = vitaminService.updateVitamin(id, newVitamin);
            if (updatedVitamin != null) {
                return ResponseEntity.ok(updatedVitamin);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vitamin dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_KADER')")
    public ResponseEntity<String> deleteVitamin(@PathVariable Integer id) {
        Vitamin vitamin = vitaminService.getVitaminById(id);
        if (vitamin != null) {
            vitaminService.deleteVitamin(id);
            return ResponseEntity.ok("Vitamin dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/export-to-excel")
    @PreAuthorize("hasAuthority('ROLE_KADER')")
    public ResponseEntity<String> exportToExcel() {
        try {
            List<Vitamin> dataVitaminList = vitaminService.getAllVitamin();
            vitaminService.exportToExcel(dataVitaminList);
            return ResponseEntity.ok("Data berhasil di export ke Excel.");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error export data ke Excel: " + e.getMessage());
        }
    }




/*
            -----------------------BASERESPONSE------------------------
*/


    @GetMapping("/vitamin/v1")
    public ResponseEntity<BaseResponse<List<Vitamin>>> getAllVitamin2() {
        List<Vitamin> vitamin = vitaminService.getAllVitamin();
        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua Vitamin", vitamin));

    }

    @GetMapping("/vitamin/v1/{id}")
    public ResponseEntity<BaseResponse<Vitamin>> getVitaminById2(@PathVariable("id") Integer id) {
        Vitamin vitamin = vitaminService.getVitaminById(id);
        if (vitamin != null) {
            return ResponseEntity.ok(BaseResponse.ok("Vitamin Ditemukan", vitamin));
        } else {
            return ResponseEntity.ok(BaseResponse.error("Vitamin Tidak Ditemukan"));
        }
    }

}

