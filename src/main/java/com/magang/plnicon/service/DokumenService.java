package com.magang.plnicon.service;

import com.magang.plnicon.entity.Dokumen;

import java.util.List;

public interface DokumenService {

    List<Dokumen> getAllDokumen();
    Dokumen getDokumenById(Integer id);
    Dokumen createDokumen(Dokumen dokumen);
    Dokumen updateDokumen(Integer id, Dokumen dokumen);
    void deleteDokumen(Integer id);

}
