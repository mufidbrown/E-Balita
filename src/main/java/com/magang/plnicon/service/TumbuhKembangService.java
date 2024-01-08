package com.magang.plnicon.service;

import com.magang.plnicon.entity.balita.TumbuhKembang;

import java.util.List;

public interface TumbuhKembangService {

    List<TumbuhKembang> getAllTumbuhKembang();
    TumbuhKembang getTumbuhKembangById(Integer id);
    TumbuhKembang createTumbuhKembang(TumbuhKembang tumbuhKembang);
    TumbuhKembang updateTumbuhKembang(Integer id, TumbuhKembang tumbuhKembang);
    void deleteTumbuhKembang(Integer id);
}
