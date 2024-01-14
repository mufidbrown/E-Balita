package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.MonitoringTindakan;
import com.magang.plnicon.repository.MonitoringTindakanRepository;
import com.magang.plnicon.service.MonitoringTindakanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MonitoringTindakanServiceImpl implements MonitoringTindakanService {

    private final MonitoringTindakanRepository monitoringTindakanRepository;

    @Autowired
    public MonitoringTindakanServiceImpl(MonitoringTindakanRepository monitoringTindakanRepository) {
        this.monitoringTindakanRepository = monitoringTindakanRepository;
    }

    @Override
    public List<MonitoringTindakan> getAllMonitoringTindakan() {
        List<MonitoringTindakan> allMonitoringTindakan = monitoringTindakanRepository.findAll();
        if (!allMonitoringTindakan.isEmpty()) {
            return allMonitoringTindakan;
        } else {
            throw new IllegalArgumentException("Daftar MonitoringTindakan kosong");
        }
    }

    @Override
    public MonitoringTindakan getMonitoringTindakanById(Integer id) {
        if (id != null) {
            Optional<MonitoringTindakan> monitoringTindakanOptional = monitoringTindakanRepository.findById(id);
            if (monitoringTindakanOptional.isPresent()) {
                return monitoringTindakanOptional.get();
            } else {
                throw new IllegalArgumentException("MonitoringTindakan dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID MonitoringTindakan tidak valid");
        }
    }

    @Override
    public MonitoringTindakan createMonitoringTindakan(MonitoringTindakan monitoringTindakan) {
        if (monitoringTindakan.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat MonitoringTindakan dengan ID yang sudah ditentukan");
        } else {
            return monitoringTindakanRepository.save(monitoringTindakan);
        }
    }

    @Override
    public MonitoringTindakan updateMonitoringTindakan(Integer id, MonitoringTindakan monitoringTindakan) {
        if (monitoringTindakanRepository.existsById(id)) {
            monitoringTindakan.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return monitoringTindakanRepository.save(monitoringTindakan);
        } else {
            throw new IllegalArgumentException("MonitoringTindakan dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteMonitoringTindakan(Integer id) {
        if (monitoringTindakanRepository.existsById(id)) {
            monitoringTindakanRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("MonitoringTindakan dengan ID " + id + " tidak ditemukan");
        }
    }
}

