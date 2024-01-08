package com.magang.plnicon.service;

import com.magang.plnicon.entity.ObatCacing;

import java.util.List;

public interface ObatCacingService {

    List<ObatCacing> getAllObatCacing();
    ObatCacing getObatCacingById(Integer id);
    ObatCacing createObatCacing(ObatCacing obatCacing);
    ObatCacing updateObatCacing(Integer id, ObatCacing obatCacing);
    void deleteObatCacing(Integer id);

}
