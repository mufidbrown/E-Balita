package com.magang.plnicon.service;

import com.magang.plnicon.entity.TindakLanjutPuskesmas;

import java.util.List;

public interface TindakLanjutPuskesmasService {

    List<TindakLanjutPuskesmas> getAllTindakLanjutPuskesmas();
    TindakLanjutPuskesmas getTindakLanjutPuskesmasById(Integer id);
    TindakLanjutPuskesmas createTindakLanjutPuskesmas(TindakLanjutPuskesmas tindakLanjutPuskesmas);
    TindakLanjutPuskesmas updateTindakLanjutPuskesmas(Integer id, TindakLanjutPuskesmas tindakLanjutPuskesmas);
    void deleteTindakLanjutPuskesmas(Integer id);


}
