package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Dokumen;
import com.magang.plnicon.repository.DokumenRepository;
import com.magang.plnicon.service.DokumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DokumenServiceImpl implements DokumenService {

    private final DokumenRepository dokumenRepository;

    @Autowired
    public DokumenServiceImpl(DokumenRepository dokumenRepository) {
        this.dokumenRepository = dokumenRepository;
    }

    @Override
    public List<Dokumen> getAllDokumen() {
        List<Dokumen> allDokumen = dokumenRepository.findAll();
        if (!allDokumen.isEmpty()) {
            return allDokumen;
        } else {
            throw new IllegalArgumentException("Daftar Dokumen kosong");
        }
    }

    @Override
    public Dokumen getDokumenById(Integer id) {
        if (id != null) {
            Optional<Dokumen> dokumenOptional = dokumenRepository.findById(id);
            if (dokumenOptional.isPresent()) {
                return dokumenOptional.get();
            } else {
                throw new IllegalArgumentException("Dokumen dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID Dokumen tidak valid");
        }
    }

    @Override
    public Dokumen createDokumen(Dokumen dokumen) {
        if (dokumen.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Dokumen dengan ID yang sudah ditentukan");
        } else {
            return dokumenRepository.save(dokumen);
        }
    }

    @Override
    public Dokumen updateDokumen(Integer id, Dokumen dokumen) {
        if (dokumenRepository.existsById(id)) {
            dokumen.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return dokumenRepository.save(dokumen);
        } else {
            throw new IllegalArgumentException("Dokumen dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteDokumen(Integer id) {
        if (dokumenRepository.existsById(id)) {
            dokumenRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Dokumen dengan ID " + id + " tidak ditemukan");
        }
    }

}
