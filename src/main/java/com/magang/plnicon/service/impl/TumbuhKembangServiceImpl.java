package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.balita.TumbuhKembang;
import com.magang.plnicon.repository.TumbuhKembangRepository;
import com.magang.plnicon.service.TumbuhKembangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TumbuhKembangServiceImpl implements TumbuhKembangService {

    private final TumbuhKembangRepository tumbuhKembangRepository;

    @Autowired
    public TumbuhKembangServiceImpl(TumbuhKembangRepository tumbuhKembangRepository) {
        this.tumbuhKembangRepository = tumbuhKembangRepository;
    }


    @Override
    public List<TumbuhKembang> getAllTumbuhKembang() {
        List< TumbuhKembang> allTumbuhKembang =  tumbuhKembangRepository.findAll();
        if (!allTumbuhKembang.isEmpty()) {
            return allTumbuhKembang;
        } else {
            throw new IllegalArgumentException("Tumbuh Kembang tidak ditemukan didalam database");
        }
    }


    @Override
    public TumbuhKembang getTumbuhKembangById(Integer id) {
        if (id != null) {
            Optional<TumbuhKembang> tumbuhKembangOptional = tumbuhKembangRepository.findById(id);
            if (tumbuhKembangOptional.isPresent()) {
                return tumbuhKembangOptional.get();
            } else {
                throw new IllegalArgumentException("Pmt dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public TumbuhKembang createTumbuhKembang(TumbuhKembang tumbuhKembang) {
        if (tumbuhKembang.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Tumbuh Kembang dengan ID yang sudah ditentukan");
        } else {
            return tumbuhKembangRepository.save(tumbuhKembang);
        }
    }



    @Override
    public TumbuhKembang updateTumbuhKembang(Integer id, TumbuhKembang newTumbuhKembang) {
        Optional<TumbuhKembang> existingTumbuhKembangOptional = tumbuhKembangRepository.findById(id);
        if (existingTumbuhKembangOptional.isPresent()) {
            TumbuhKembang existingTumbuhKembang = existingTumbuhKembangOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingTumbuhKembang.setUsia_bulan(newTumbuhKembang.getUsia_bulan());
            existingTumbuhKembang.setTanggal_sampel(newTumbuhKembang.getTanggal_sampel());
            existingTumbuhKembang.setJumlah_indikator(newTumbuhKembang.getJumlah_indikator());
            existingTumbuhKembang.setHasil(newTumbuhKembang.getHasil());


            return tumbuhKembangRepository.save(existingTumbuhKembang);
        } else {
            throw new EntityNotFoundException("Tumbuh Kembang dengan ID " + id + " tidak ditemukan");
        }
    }



    @Override
    public void deleteTumbuhKembang(Integer id) {
        if (tumbuhKembangRepository.existsById(id)) {
            tumbuhKembangRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Tumbuh Kembang dengan ID " + id + " tidak ditemukan");
        }
    }
}
