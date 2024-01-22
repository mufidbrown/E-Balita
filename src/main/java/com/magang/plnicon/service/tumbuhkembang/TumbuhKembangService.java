package com.magang.plnicon.service.tumbuhkembang;

import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.entity.TumbuhKembang;

import java.util.List;

public interface TumbuhKembangService {

    List<TumbuhKembang> getAllTumbuhKembang();
    TumbuhKembang getTumbuhKembangById(Integer id);
    TumbuhKembang createTumbuhKembang(TumbuhKembang tumbuhKembang);
    TumbuhKembang updateTumbuhKembang(Integer id, TumbuhKembang tumbuhKembang);
    void deleteTumbuhKembang(Integer id);

    BaseResponse<?> testtumbuhkembang();

    BaseResponse<?> testParameterTumbuhKembang(Integer idTumbuhKembang);
}
