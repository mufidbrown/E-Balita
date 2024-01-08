package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Vitamin;
import com.magang.plnicon.repository.VitaminRepository;
import com.magang.plnicon.service.VitaminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class VitaminServiceImpl implements VitaminService {

    private final VitaminRepository vitaminRepository;

    @Autowired
    public VitaminServiceImpl(VitaminRepository vitaminRepository) {
        this.vitaminRepository = vitaminRepository;
    }


    @Override
    public List<Vitamin> getAllVitamin() {
        List<Vitamin> allVitamin = vitaminRepository.findAll();
        if (!allVitamin.isEmpty()) {
            return allVitamin;
        } else {
            throw new IllegalArgumentException("Vitamin tidak ditemukan didalam database");
        }
    }


    @Override
    public Vitamin getVitaminById(Integer id) {
        if (id != null) {
            Optional<Vitamin> vitaminOptional = vitaminRepository.findById(id);
            if (vitaminOptional.isPresent()) {
                return vitaminOptional.get();
            } else {
                throw new IllegalArgumentException("Vitamin dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public Vitamin createVitamin(Vitamin vitamin) {
        if (vitamin.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Vitamin dengan ID yang sudah ditentukan");
        } else {
            return vitaminRepository.save(vitamin);
        }
    }



    @Override
    public Vitamin updateVitamin(Integer id, Vitamin newVitamin) {
        Optional<Vitamin> existingVitaminOptional = vitaminRepository.findById(id);
        if (existingVitaminOptional.isPresent()) {
            Vitamin existingVitamin = existingVitaminOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingVitamin.setNama_balita(newVitamin.getNama_balita());
            existingVitamin.setTanggal_vitamin(newVitamin.getTanggal_vitamin());
            existingVitamin.setUsia_bulan(newVitamin.getUsia_bulan());
            existingVitamin.setJenis_vitamin(newVitamin.getJenis_vitamin());
            existingVitamin.setJumlah_vitamin(newVitamin.getJumlah_vitamin());
            existingVitamin.setKeterangan(newVitamin.getKeterangan());



            return vitaminRepository.save(existingVitamin);
        } else {
            throw new EntityNotFoundException("Pmt dengan ID " + id + " tidak ditemukan");
        }
    }


    @Override
    public void deleteVitamin(Integer id) {
        if (vitaminRepository.existsById(id)) {
            vitaminRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pmt dengan ID " + id + " tidak ditemukan");
        }
    }
}
