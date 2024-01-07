package com.magang.plnicon.service;


import com.magang.plnicon.entity.Pengguna;

import java.util.List;

public interface PenggunaService {

    List<Pengguna> getAllPengguna();
    Pengguna getPenggunaById(Integer id);
    Pengguna createPengguna(Pengguna pengguna);
    Pengguna updatePengguna(Integer id, Pengguna pengguna);
    void deletePengguna(Integer id);

}
