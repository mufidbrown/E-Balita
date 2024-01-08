package com.magang.plnicon.service;

import com.magang.plnicon.entity.master.Posyandu;

import java.util.List;

public interface PosyanduService {

    List<Posyandu> getAllPosyandu();
    Posyandu getPosyanduById(Integer id);
    Posyandu createPosyandu(Posyandu posyandu);
    Posyandu updatePosyandu(Integer id, Posyandu posyanduDetails);
    void deletePosyandu(Integer id);
}