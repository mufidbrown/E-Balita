package com.magang.plnicon.service.impl;


import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.repository.BalitaRepository;
import com.magang.plnicon.service.BalitaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BalitaServiceImpl implements BalitaService {

    @Autowired
    private BalitaRepository balitaRepository;

    @Override
    public Balita saveBalita(BalitaDTO balitaDTO) {
        // Perform validation and business logic
        Balita balita = new Balita();
        balita.setNamaLengkap(balitaDTO.getNamaLengkap());
        balita.setUmur(balitaDTO.getUmur());
        // Set other fields from DTO

        return balitaRepository.save(balita);
    }

    @Override
    public List<Balita> getAllBalitas() {
        return balitaRepository.findAll();
    }

    @Override
    public Balita getBalitaById(Long id) {
        return balitaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Balita tidak ditemukan dengan id: " + id));
    }

    // Implement other service methods
}
