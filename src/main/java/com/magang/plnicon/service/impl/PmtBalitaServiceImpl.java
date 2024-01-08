package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.balita.PmtBalita;
import com.magang.plnicon.repository.PmtBalitaRepository;
import com.magang.plnicon.service.PmtBalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new IllegalArgumentException("PmtBalita tidak ditemukan didalam database");
        }
    }

    
}
