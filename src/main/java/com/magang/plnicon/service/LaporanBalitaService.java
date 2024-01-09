package com.magang.plnicon.service;

import com.magang.plnicon.entity.LaporanBalita;

import java.util.List;

public interface LaporanBalitaService {

    List<LaporanBalita> getAllLaporanBalita();
    LaporanBalita getLaporanBalitaById(Integer id);
    LaporanBalita createLaporanBalita(LaporanBalita laporanBalita);
    LaporanBalita updateLaporanBalita(Integer id, LaporanBalita laporanBalita);
    void deleteLaporanBalita(Integer id);

}
