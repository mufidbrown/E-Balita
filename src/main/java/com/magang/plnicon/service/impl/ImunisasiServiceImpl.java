package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Imunisasi;
import com.magang.plnicon.repository.ImunisasiRepository;
import com.magang.plnicon.service.ImunisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ImunisasiServiceImpl implements ImunisasiService {

    private final ImunisasiRepository imunisasiRepository;

    @Autowired
    public ImunisasiServiceImpl(ImunisasiRepository imunisasiRepository) {
        this.imunisasiRepository = imunisasiRepository;
    }


    @Override
    public List<Imunisasi> getAllImunisasi() {
        List<Imunisasi> allImunisasi = imunisasiRepository.findAll();
        if (!allImunisasi.isEmpty()) {
            return allImunisasi;
        } else {
            throw new IllegalArgumentException("Imunisasi tidak ditemukan didalam database");
        }
    }


    @Override
    public Imunisasi getImunisasiById(Integer id) {
        if (id != null) {
            Optional<Imunisasi> imunisasiOptional = imunisasiRepository.findById(id);
            if (imunisasiOptional.isPresent()) {
                return imunisasiOptional.get();
            } else {
                throw new IllegalArgumentException("Imunisasi dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public Imunisasi createImunisasi(Imunisasi imunisasi) {
        if (imunisasi.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Imunisasi dengan ID yang sudah ditentukan");
        } else {
            return imunisasiRepository.save(imunisasi);
        }
    }

    @Override
    public Imunisasi updateImunisasi(Integer id, Imunisasi newImunisasi) {
        Optional<Imunisasi> existingImunisasiOptional = imunisasiRepository.findById(id);
        if (existingImunisasiOptional.isPresent()) {
            Imunisasi existingImunisasi = existingImunisasiOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingImunisasi.setNama_balita(newImunisasi.getNama_balita());
            existingImunisasi.setTanggal_imunisasi(newImunisasi.getTanggal_imunisasi());
            existingImunisasi.setJenis_imunisasi(newImunisasi.getJenis_imunisasi());
            existingImunisasi.setKeterangan(newImunisasi.getKeterangan());


            return imunisasiRepository.save(existingImunisasi);
        } else {
            throw new EntityNotFoundException("Imunisasi dengan ID " + id + " tidak ditemukan");
        }
    }


    @Override
    public void deleteImunisasi(Integer id) {
        if (imunisasiRepository.existsById(id)) {
            imunisasiRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Imunisasi dengan ID " + id + " tidak ditemukan");
        }
    }

}
