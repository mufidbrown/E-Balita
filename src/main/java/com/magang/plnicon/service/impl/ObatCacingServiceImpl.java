package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.ObatCacing;
import com.magang.plnicon.repository.ObatCacingRepository;
import com.magang.plnicon.service.ObatCacingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ObatCacingServiceImpl implements ObatCacingService {

    private final ObatCacingRepository obatCacingRepository;

    @Autowired
    public ObatCacingServiceImpl(ObatCacingRepository obatCacingRepository) {
        this.obatCacingRepository = obatCacingRepository;
    }


    @Override
    public List<ObatCacing> getAllObatCacing() {
        List< ObatCacing> allObatCacing =  obatCacingRepository.findAll();
        if (!allObatCacing.isEmpty()) {
            return allObatCacing;
        } else {
            throw new IllegalArgumentException("Obat Cacing tidak ditemukan didalam database");
        }
    }


    @Override
    public ObatCacing getObatCacingById(Integer id) {
        if (id != null) {
            Optional<ObatCacing> obatCacingOptional = obatCacingRepository.findById(id);
            if (obatCacingOptional.isPresent()) {
                return obatCacingOptional.get();
            } else {
                throw new IllegalArgumentException("Obat Cacing dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public ObatCacing createObatCacing(ObatCacing obatCacing) {
        if (obatCacing.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Obat Cacing dengan ID yang sudah ditentukan");
        } else {
            return obatCacingRepository.save(obatCacing);
        }
    }


    @Override
    public ObatCacing updateObatCacing(Integer id, ObatCacing newObatCacing) {
        Optional<ObatCacing> existingObatCacingOptional = obatCacingRepository.findById(id);
        if (existingObatCacingOptional.isPresent()) {
            ObatCacing existingObatCacing = existingObatCacingOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingObatCacing.setNama_balita(newObatCacing.getNama_balita());
            existingObatCacing.setUsia_bulan(newObatCacing.getUsia_bulan());
            existingObatCacing.setTanggal_pemberian_obat(newObatCacing.getTanggal_pemberian_obat());
            existingObatCacing.setNama_obat(newObatCacing.getNama_obat());
            existingObatCacing.setKeterangan(newObatCacing.getKeterangan());

            return obatCacingRepository.save(existingObatCacing);
        } else {
            throw new EntityNotFoundException("Pmt dengan ID " + id + " tidak ditemukan");
        }
    }


    @Override
    public void deleteObatCacing(Integer id) {
        if (obatCacingRepository.existsById(id)) {
            obatCacingRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Obat Cacing dengan ID " + id + " tidak ditemukan");
        }
    }
}

