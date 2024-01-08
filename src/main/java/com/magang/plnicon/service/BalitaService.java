package com.magang.plnicon.service;

import com.magang.plnicon.entity.Balita;

import java.util.List;

public interface BalitaService {

    List<Balita> getAllBalita();
    Balita getBalitaById(Integer id);
    Balita createBalita(Balita balita);
    Balita updateBalita(Integer id, Balita balita);
    void deleteBalita(Integer id);

}
