package com.magang.plnicon.service;

import com.magang.plnicon.entity.PmtBalita;

import java.util.List;

public interface PmtBalitaService {

    List<PmtBalita> getAllPmtBalita();
    PmtBalita getPmtBalitaById(Integer id);
    PmtBalita createPmtBalita(PmtBalita pmtBalita);
    PmtBalita updatePmtBalita(Integer id, PmtBalita pmtBalita);
    void deletePmtBalita(Integer id);

}
