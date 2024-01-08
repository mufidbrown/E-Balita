package com.magang.plnicon.service;

import com.magang.plnicon.entity.master.Puskesmas;

import java.util.List;

public interface PuskesmasService {
    List<Puskesmas> getAllPuskesmas();
    Puskesmas getPuskesmasById(Integer id);
    Puskesmas createPuskesmas(Puskesmas puskesmas);
    Puskesmas updatePuskesmas(Integer id, Puskesmas puskesmas);
    void deletePuskesmas(Integer id);
}
