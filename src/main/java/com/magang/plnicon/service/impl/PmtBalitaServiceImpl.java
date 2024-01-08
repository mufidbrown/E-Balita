package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.balita.PmtBalita;
import com.magang.plnicon.repository.PmtBalitaRepository;
import com.magang.plnicon.service.PmtBalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PmtBalitaServiceImpl implements PmtBalitaService {

    private final PmtBalitaRepository pmtBalitaRepository;

    @Autowired
    public PmtBalitaServiceImpl(PmtBalitaRepository pmtBalitaRepository) {
        this.pmtBalitaRepository = pmtBalitaRepository;
    }

    @Override
    public List<PmtBalita> getAllPmtBalita() {
        List<PmtBalita> allPmtBalita = pmtBalitaRepository.findAll();
        if (!allPmtBalita.isEmpty()) {
            return allPmtBalita;
        } else {
            throw new IllegalArgumentException("Pmt Balita tidak ditemukan didalam database");
        }
    }

    @Override
    public PmtBalita getPmtBalitaById(Integer id) {
        if (id != null) {
            Optional<PmtBalita> pmtBalitaOptional = pmtBalitaRepository.findById(id);
            if (pmtBalitaOptional.isPresent()) {
                return pmtBalitaOptional.get();
            } else {
                throw new IllegalArgumentException("Pmt Balita dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public PmtBalita createPmtBalita(PmtBalita pmtBalita) {
        if (pmtBalita.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Pmt Balita dengan ID yang sudah ditentukan");
        } else {
            return pmtBalitaRepository.save(pmtBalita);
        }
    }

    @Override
    public PmtBalita updatePmtBalita(Integer id, PmtBalita newPmtBalita) {
        Optional<PmtBalita> existingPmtBalitaOptional = pmtBalitaRepository.findById(id);
        if (existingPmtBalitaOptional.isPresent()) {
            PmtBalita existingPmtBalita = existingPmtBalitaOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingPmtBalita.setNama_balita(newPmtBalita.getNama_balita());
            existingPmtBalita.setTanggal_pmt(newPmtBalita.getTanggal_pmt());
            existingPmtBalita.setMakanan_pmt(newPmtBalita.getMakanan_pmt());
            existingPmtBalita.setKeterangan(newPmtBalita.getKeterangan());

            return pmtBalitaRepository.save(existingPmtBalita);
        } else {
            throw new EntityNotFoundException("Pmt Balita dengan ID " + id + " tidak ditemukan");
        }
    }


    @Override
    public void deletePmtBalita(Integer id) {
        if (pmtBalitaRepository.existsById(id)) {
            pmtBalitaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pmt Balita dengan ID " + id + " tidak ditemukan");
        }
    }
}
