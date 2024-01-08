package com.magang.plnicon.service;

import com.magang.plnicon.entity.Imunisasi;

import java.util.List;

public interface ImunisasiService {

    List<Imunisasi> getAllImunisasi();
    Imunisasi getImunisasiById(Integer id);
    Imunisasi createImunisasi(Imunisasi imunisasi);
    Imunisasi updateImunisasi(Integer id, Imunisasi imunisasi);
    void deleteImunisasi(Integer id);

}
