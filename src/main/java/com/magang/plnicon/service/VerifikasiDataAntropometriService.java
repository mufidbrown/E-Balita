package com.magang.plnicon.service;

import com.magang.plnicon.entity.VerifikasiDataAntropometri;

import java.util.List;

public interface VerifikasiDataAntropometriService {

    List<VerifikasiDataAntropometri> getAllVerifikasiDataAntropometri();
    VerifikasiDataAntropometri getVerifikasiDataAntropometriById(Integer id);
    VerifikasiDataAntropometri createVerifikasiDataAntropometri(VerifikasiDataAntropometri verifikasiDataAntropometri);
    VerifikasiDataAntropometri updateVerifikasiDataAntropometri(Integer id, VerifikasiDataAntropometri verifikasiDataAntropometri);
    void deleteVerifikasiDataAntropometri(Integer id);

}
