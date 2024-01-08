package com.magang.plnicon.service;

import com.magang.plnicon.entity.Vitamin;

import java.util.List;

public interface VitaminService {

    List<Vitamin> getAllVitamin();
    Vitamin getVitaminById(Integer id);
    Vitamin createVitamin(Vitamin vitamin);
    Vitamin updateVitamin(Integer id, Vitamin vitamin);
    void deleteVitamin(Integer id);

}
