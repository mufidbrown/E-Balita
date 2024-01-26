package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.MonitoringStunting;
import com.magang.plnicon.repository.MonitoringStuntingRepository;
import com.magang.plnicon.service.MonitoringStuntingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoringStuntingServiceImpl implements MonitoringStuntingService {

    private final MonitoringStuntingRepository monitoringStuntingRepository;

    @Autowired
    public MonitoringStuntingServiceImpl(MonitoringStuntingRepository monitoringStuntingRepository) {
        this.monitoringStuntingRepository = monitoringStuntingRepository;
    }

    @Override
    public List<MonitoringStunting> getAllMonitoringStunting() {
        List<MonitoringStunting> allMonitoringStunting = monitoringStuntingRepository.findAll();
        if (!allMonitoringStunting.isEmpty()) {
            return allMonitoringStunting;
        } else {
            throw new IllegalArgumentException("Daftar MonitoringStunting kosong");
        }
    }

    @Override
    public MonitoringStunting getMonitoringStuntingById(Integer id) {
        if (id != null) {
            Optional<MonitoringStunting> monitoringStuntingOptional = monitoringStuntingRepository.findById(id);
            if (monitoringStuntingOptional.isPresent()) {
                return monitoringStuntingOptional.get();
            } else {
                throw new IllegalArgumentException("MonitoringStunting dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID MonitoringStunting tidak valid");
        }
    }

    @Override
    public MonitoringStunting createMonitoringStunting(MonitoringStunting monitoringStunting) {
        if (monitoringStunting.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat pengguna dengan ID yang sudah ditentukan");
        } else {
            return monitoringStuntingRepository.save(monitoringStunting);
        }
    }

    @Override
    public MonitoringStunting updateMonitoringStunting(Integer id, MonitoringStunting monitoringStunting) {
        if (monitoringStuntingRepository.existsById(id)) {
            monitoringStunting.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return monitoringStuntingRepository.save(monitoringStunting);
        } else {
            throw new IllegalArgumentException("Pengguna dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteMonitoringStunting(Integer id) {
        if (monitoringStuntingRepository.existsById(id)) {
            monitoringStuntingRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pengguna dengan ID " + id + " tidak ditemukan");
        }
    }
}
