package com.magang.plnicon.controller;

import com.magang.plnicon.entity.MonitoringTindakan;
import com.magang.plnicon.service.MonitoringTindakanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitoringtindakan")
public class MonitoringTindakanController {

    private final MonitoringTindakanService monitoringTindakanService;

    @Autowired
    public MonitoringTindakanController(MonitoringTindakanService monitoringTindakanService) {
        this.monitoringTindakanService = monitoringTindakanService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMonitoringTindakan() {
        List<MonitoringTindakan> allMonitoringTindakan = monitoringTindakanService.getAllMonitoringTindakan();
        if (!allMonitoringTindakan.isEmpty()) {
            return ResponseEntity.ok(allMonitoringTindakan);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada pengguna yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getMonitoringTindakanById(@PathVariable Integer id) {
        MonitoringTindakan monitoringTindakan = monitoringTindakanService.getMonitoringTindakanById(id);
        if (monitoringTindakan != null) {
            return ResponseEntity.ok(monitoringTindakan);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MonitoringTindakan dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createMonitoringTindakan(@RequestBody MonitoringTindakan monitoringTindakan) {
        if (monitoringTindakan != null) {
            try {
                MonitoringTindakan createdMonitoringTindakan = monitoringTindakanService.createMonitoringTindakan(monitoringTindakan);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdMonitoringTindakan);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat MonitoringTindakan: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid MonitoringTindakan input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<MonitoringTindakan> updateMonitoringTindakan(@PathVariable Integer id, @RequestBody MonitoringTindakan newMonitoringTindakan) {
        try {
            MonitoringTindakan updatedMonitoringTindakan = monitoringTindakanService.updateMonitoringTindakan(id, newMonitoringTindakan);
            if (updatedMonitoringTindakan!= null) {
                return ResponseEntity.ok(updatedMonitoringTindakan);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "MonitoringTindakan dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMonitoringTindakan(@PathVariable Integer id) {
        MonitoringTindakan monitoringTindakan = monitoringTindakanService.getMonitoringTindakanById(id);
        if (monitoringTindakan != null) {
            monitoringTindakanService.deleteMonitoringTindakan(id);
            return ResponseEntity.ok("Pengguna dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
