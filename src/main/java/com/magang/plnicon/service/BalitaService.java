package com.magang.plnicon.service;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.Balita;

import java.util.List;

public interface BalitaService {

    Balita saveBalita(BalitaDTO balitaDTO);
    List<Balita> getAllBalitas();
    Balita getBalitaById(Long id);

}