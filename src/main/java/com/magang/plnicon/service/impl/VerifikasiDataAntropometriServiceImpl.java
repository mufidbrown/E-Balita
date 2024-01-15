package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.VerifikasiDataAntropometri;
import com.magang.plnicon.repository.VerifikasiDataAntropometriRepository;
import com.magang.plnicon.service.VerifikasiDataAntropometriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VerifikasiDataAntropometriServiceImpl implements VerifikasiDataAntropometriService {

    private final VerifikasiDataAntropometriRepository verifikasiDataAntropometriRepository;

    @Autowired
    public VerifikasiDataAntropometriServiceImpl(VerifikasiDataAntropometriRepository verifikasiDataAntropometriRepository) {
        this.verifikasiDataAntropometriRepository = verifikasiDataAntropometriRepository;
    }

    @Override
    public List<VerifikasiDataAntropometri> getAllVerifikasiDataAntropometri() {
        List<VerifikasiDataAntropometri> allVerifikasiDataAntropometri = verifikasiDataAntropometriRepository.findAll();
        if (!allVerifikasiDataAntropometri.isEmpty()) {
            return allVerifikasiDataAntropometri;
        } else {
            throw new IllegalArgumentException("Daftar VerifikasiDataAntropometri kosong");
        }
    }

    @Override
    public VerifikasiDataAntropometri getVerifikasiDataAntropometriById(Integer id) {
        if (id != null) {
            Optional<VerifikasiDataAntropometri> verifikasiDataAntropometriOptional = verifikasiDataAntropometriRepository.findById(id);
            if (verifikasiDataAntropometriOptional.isPresent()) {
                return verifikasiDataAntropometriOptional.get();
            } else {
                throw new IllegalArgumentException("VerifikasiDataAntropometri dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID VerifikasiDataAntropometri tidak valid");
        }
    }

    @Override
    public VerifikasiDataAntropometri createVerifikasiDataAntropometri(VerifikasiDataAntropometri verifikasiDataAntropometri) {
        if (verifikasiDataAntropometri.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat VerifikasiDataAntropometri dengan ID yang sudah ditentukan");
        } else {
            return verifikasiDataAntropometriRepository.save(verifikasiDataAntropometri);
        }
    }

    @Override
    public VerifikasiDataAntropometri updateVerifikasiDataAntropometri(Integer id, VerifikasiDataAntropometri verifikasiDataAntropometri) {
        if (verifikasiDataAntropometriRepository.existsById(id)) {
            verifikasiDataAntropometri.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return verifikasiDataAntropometriRepository.save(verifikasiDataAntropometri);
        } else {
            throw new IllegalArgumentException("VerifikasiDataAntropometri dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteVerifikasiDataAntropometri(Integer id) {
        if (verifikasiDataAntropometriRepository.existsById(id)) {
            verifikasiDataAntropometriRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("VerifikasiDataAntropometri dengan ID " + id + " tidak ditemukan");
        }
    }
}
