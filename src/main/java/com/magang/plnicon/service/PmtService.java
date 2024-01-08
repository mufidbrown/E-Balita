package com.magang.plnicon.service;

import com.magang.plnicon.entity.Pmt;

import java.util.List;

public interface PmtService {

    List<Pmt> getAllPmt();
    Pmt getPmtById(Integer id);
    Pmt createPmt(Pmt pmt);
    Pmt updatePmt(Integer id, Pmt pmt);
    void deletePmt(Integer id);

}
