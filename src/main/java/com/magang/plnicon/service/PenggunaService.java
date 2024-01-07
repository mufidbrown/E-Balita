package com.magang.plnicon.service;


import com.magang.plnicon.entity.Pengguna;
import com.magang.plnicon.entity.Pmt;
import com.magang.plnicon.payload.request.PenggunaRequest;

import java.util.List;

public interface PenggunaService {

    List<PenggunaRequest> getAllPengguna();
    Pengguna getPenggunaById(Integer id);
    Pengguna createPengguna(Pmt pmt);
    Pengguna updatePengguna(Integer id, Pengguna pengguna);
    void deletePengguna(Integer id);

}
