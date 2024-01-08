package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Antropometri;
import com.magang.plnicon.repository.AntropometriRepository;
import com.magang.plnicon.service.AntropometriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntropometriServiceImpl implements AntropometriService {

    private final AntropometriRepository antropometriRepository;

    @Autowired
    public AntropometriServiceImpl(AntropometriRepository antropometriRepository) {
        this.antropometriRepository = antropometriRepository;
    }

    @Override
    public List<Antropometri> getAllAntropometri() {
        List<Antropometri> allAntropometri = antropometriRepository.findAll();
        if (!allAntropometri.isEmpty()) {
            return allAntropometri;
        } else {
            throw new IllegalArgumentException("Daftar Antropometri Kosong");
        }
    }

    @Override
    public Antropometri getAntropometriById(Integer id) {
        if (id != null) {
            Optional<Antropometri> antropometriOptional = antropometriRepository.findById(id);
            if (antropometriOptional.isPresent()) {
                return antropometriOptional.get();
            } else {
                throw new IllegalArgumentException("Antropometri dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID Antropometri tidak valid");
        }
    }

    @Override
    public Antropometri createAntropometri(Antropometri antropometri) {
        if (antropometri.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Antropometri dengan ID yang sudah ditentukan");
        } else {
            return antropometriRepository.save(antropometri);
        }
    }

    @Override
    public Antropometri updateAntropometri(Integer id, Antropometri antropometri) {
        if (antropometriRepository.existsById(id)) {
            antropometri.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return antropometriRepository.save(antropometri);
        } else {
            throw new IllegalArgumentException("Antropometri dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteAntropometri(Integer id) {
        if (antropometriRepository.existsById(id)) {
            antropometriRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Antropometri dengan ID " + id + " tidak ditemukan");
        }
    }
}

