package com.magang.plnicon.controller;


import com.magang.plnicon.entity.MonitoringStunting;
import com.magang.plnicon.service.MonitoringStuntingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitoring_stuntings")
public class MonitoringStuntingController {

    private final MonitoringStuntingService monitoringStuntingService;

    @Autowired
    public MonitoringStuntingController(MonitoringStuntingService monitoringStuntingService) {
        this.monitoringStuntingService = monitoringStuntingService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getAllMonitoringStunting() {
        List<MonitoringStunting> allMonitoringStunting = monitoringStuntingService.getAllMonitoringStunting();
        if (!allMonitoringStunting.isEmpty()) {
            return ResponseEntity.ok(allMonitoringStunting);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada MonitoringStunting yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getMonitoringStuntingById(@PathVariable Integer id) {
        MonitoringStunting monitoringStunting = monitoringStuntingService.getMonitoringStuntingById(id);
        if (monitoringStunting != null) {
            return ResponseEntity.ok(monitoringStunting);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pengguna dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> createMonitoringStunting(@RequestBody MonitoringStunting monitoringStunting) {
        if (monitoringStunting != null) {
            try {
                MonitoringStunting createdMonitoringStunting = monitoringStuntingService.createMonitoringStunting(monitoringStunting);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdMonitoringStunting);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat MonitoringStunting: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid MonitoringStunting input");
        }
    }



    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MonitoringStunting> updateMonitoringStunting(@PathVariable Integer id, @RequestBody MonitoringStunting newMonitoringStunting) {
        try {
            MonitoringStunting updatedMonitoringStunting = monitoringStuntingService.updateMonitoringStunting(id, newMonitoringStunting);
            if (updatedMonitoringStunting!= null) {
                return ResponseEntity.ok(updatedMonitoringStunting);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengguna dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteMonitoringStunting(@PathVariable Integer id) {
        MonitoringStunting monitoringStunting = monitoringStuntingService.getMonitoringStuntingById(id);
        if (monitoringStunting != null) {
            monitoringStuntingService.deleteMonitoringStunting(id);
            return ResponseEntity.ok("Pengguna dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
