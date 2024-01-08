package com.magang.plnicon.service;

import com.magang.plnicon.entity.Antropometri;

import java.util.List;

public interface AntropometriService {

    List<Antropometri> getAllAntropometri();
    Antropometri getAntropometriById(Integer id);
    Antropometri createAntropometri(Antropometri antropometri);
    Antropometri updateAntropometri(Integer id, Antropometri antropometri);
    void deleteAntropometri(Integer id);

}
