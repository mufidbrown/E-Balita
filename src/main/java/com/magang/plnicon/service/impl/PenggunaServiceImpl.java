package com.magang.plnicon.service.impl;


import com.magang.plnicon.entity.Pengguna;
import com.magang.plnicon.repository.PenggunaRepository;
import com.magang.plnicon.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PenggunaServiceImpl implements PenggunaService {

    private final PenggunaRepository penggunaRepository;

    @Autowired
    public PenggunaServiceImpl(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    @Override
    public List<Pengguna> getAllPengguna() {
        List<Pengguna> allPengguna = penggunaRepository.findAll();
        if (!allPengguna.isEmpty()) {
            return allPengguna;
        } else {
            throw new IllegalArgumentException("Daftar pengguna kosong");
        }
    }

    @Override
    public Pengguna getPenggunaById(Integer id) {
        if (id != null) {
            Optional<Pengguna> penggunaOptional = penggunaRepository.findById(id);
            if (penggunaOptional.isPresent()) {
                return penggunaOptional.get();
            } else {
                throw new IllegalArgumentException("Pengguna dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID pengguna tidak valid");
        }
    }

    @Override
    public Pengguna createPengguna(Pengguna pengguna) {
        if (pengguna.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat pengguna dengan ID yang sudah ditentukan");
        } else {
            return penggunaRepository.save(pengguna);
        }
    }

    @Override
    public Pengguna updatePengguna(Integer id, Pengguna pengguna) {
        if (penggunaRepository.existsById(id)) {
            pengguna.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return penggunaRepository.save(pengguna);
        } else {
            throw new IllegalArgumentException("Pengguna dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deletePengguna(Integer id) {
        if (penggunaRepository.existsById(id)) {
            penggunaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pengguna dengan ID " + id + " tidak ditemukan");
        }
    }
}

