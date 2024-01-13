package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.TindakLanjutPuskesmas;
import com.magang.plnicon.repository.TindakLanjutPuskesmasRepository;
import com.magang.plnicon.service.TindakLanjutPuskesmasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TindakLanjutPuskesmasServiceImpl implements TindakLanjutPuskesmasService {

    private final TindakLanjutPuskesmasRepository tindakLanjutPuskesmasRepository;

    @Autowired
    public TindakLanjutPuskesmasServiceImpl(TindakLanjutPuskesmasRepository tindakLanjutPuskesmasRepository) {
        this.tindakLanjutPuskesmasRepository = tindakLanjutPuskesmasRepository;
    }

    @Override
    public List<TindakLanjutPuskesmas> getAllTindakLanjutPuskesmas() {
        List<TindakLanjutPuskesmas> allTindakLanjutPuskesmas = tindakLanjutPuskesmasRepository.findAll();
        if (!allTindakLanjutPuskesmas.isEmpty()) {
            return allTindakLanjutPuskesmas;
        } else {
            throw new IllegalArgumentException("Daftar TindakLanjutPuskesmas kosong");
        }
    }

    @Override
    public TindakLanjutPuskesmas getTindakLanjutPuskesmasById(Integer id) {
        if (id != null) {
            Optional<TindakLanjutPuskesmas> tindakLanjutPuskesmasOptional = tindakLanjutPuskesmasRepository.findById(id);
            if (tindakLanjutPuskesmasOptional.isPresent()) {
                return tindakLanjutPuskesmasOptional.get();
            } else {
                throw new IllegalArgumentException("TindakLanjutPuskesmas dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID TindakLanjutPuskesmas tidak valid");
        }
    }

    @Override
    public TindakLanjutPuskesmas createTindakLanjutPuskesmas(TindakLanjutPuskesmas tindakLanjutPuskesmas) {
        if (tindakLanjutPuskesmas.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat TindakLanjutPuskesmas dengan ID yang sudah ditentukan");
        } else {
            return tindakLanjutPuskesmasRepository.save(tindakLanjutPuskesmas);
        }
    }

    @Override
    public TindakLanjutPuskesmas updateTindakLanjutPuskesmas(Integer id, TindakLanjutPuskesmas tindakLanjutPuskesmas) {
        if (tindakLanjutPuskesmasRepository.existsById(id)) {
            tindakLanjutPuskesmas.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return tindakLanjutPuskesmasRepository.save(tindakLanjutPuskesmas);
        } else {
            throw new IllegalArgumentException("TindakLanjutPuskesmas dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteTindakLanjutPuskesmas(Integer id) {
        if (tindakLanjutPuskesmasRepository.existsById(id)) {
            tindakLanjutPuskesmasRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("TindakLanjutPuskesmas dengan ID " + id + " tidak ditemukan");
        }
    }

}
