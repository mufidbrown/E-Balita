package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.LaporanBalita;
import com.magang.plnicon.repository.LaporanBalitaRepository;
import com.magang.plnicon.service.LaporanBalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaporanBalitaServiceImpl implements LaporanBalitaService {

    private final LaporanBalitaRepository laporanBalitaRepository;

    @Autowired
    public LaporanBalitaServiceImpl(LaporanBalitaRepository laporanBalitaRepository) {
        this.laporanBalitaRepository = laporanBalitaRepository;
    }

    @Override
    public List<LaporanBalita> getAllLaporanBalita() {
        List<LaporanBalita> allLaporanBalita = laporanBalitaRepository.findAll();
        if (!allLaporanBalita.isEmpty()) {
            return allLaporanBalita;
        } else {
            throw new IllegalArgumentException("Daftar LaporanBalita kosong");
        }
    }

    @Override
    public LaporanBalita getLaporanBalitaById(Integer id) {
        if (id != null) {
            Optional<LaporanBalita> laporanBalitaOptional = laporanBalitaRepository.findById(id);
            if (laporanBalitaOptional.isPresent()) {
                return laporanBalitaOptional.get();
            } else {
                throw new IllegalArgumentException("LaporanBalita dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID LaporanBalita tidak valid");
        }
    }

    @Override
    public LaporanBalita createLaporanBalita(LaporanBalita laporanBalita) {
        if (laporanBalita.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat LaporanBalita dengan ID yang sudah ditentukan");
        } else {
            return laporanBalitaRepository.save(laporanBalita);
        }
    }

    @Override
    public LaporanBalita updateLaporanBalita(Integer id, LaporanBalita laporanBalita) {
        if (laporanBalitaRepository.existsById(id)) {
            laporanBalita.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return laporanBalitaRepository.save(laporanBalita);
        } else {
            throw new IllegalArgumentException("LaporanBalita dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteLaporanBalita(Integer id) {
        if (laporanBalitaRepository.existsById(id)) {
            laporanBalitaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("LaporanBalita dengan ID " + id + " tidak ditemukan");
        }
    }

}
