package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.repository.BalitaRepository;
import com.magang.plnicon.service.BalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalitaServiceImpl implements BalitaService {

    private final BalitaRepository balitaRepository;

    @Autowired
    public BalitaServiceImpl(BalitaRepository balitaRepository) {
        this.balitaRepository = balitaRepository;
    }

    @Override
    public List<Balita> getAllBalita() {
        List<Balita> allBalita = balitaRepository.findAll();
        if (!allBalita.isEmpty()) {
            return allBalita;
        } else {
            throw new IllegalArgumentException("Daftar Balita kosong");
        }
    }

    @Override
    public Balita getBalitaById(Integer id) {
        if (id != null) {
            Optional<Balita> balitaOptional = balitaRepository.findById(id);
            if (balitaOptional.isPresent()) {
                return balitaOptional.get();
            } else {
                throw new IllegalArgumentException("Balita dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID Balita tidak valid");
        }
    }

    @Override
    public Balita createBalita(Balita balita) {
        if (balita.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Balita dengan ID yang sudah ditentukan");
        } else {
            return balitaRepository.save(balita);
        }
    }

    @Override
    public Balita updateBalita(Integer id, Balita balita) {
        if (balitaRepository.existsById(id)) {
            balita.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return balitaRepository.save(balita);
        } else {
            throw new IllegalArgumentException("Balita dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteBalita(Integer id) {
        if (balitaRepository.existsById(id)) {
            balitaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Balita dengan ID " + id + " tidak ditemukan");
        }
    }
}
