package com.magang.plnicon.service;

import com.magang.plnicon.dto.BalitaRecordDto;
import com.magang.plnicon.dto.ExternalBalitaRecordDto;
import com.magang.plnicon.entity.BalitaRecord;

import java.util.List;
import java.util.Map;

public interface BalitaRecordService {

    BalitaRecord getRecentBalitaRecord(long balitaId);

    BalitaRecord updateBalitaRecord(String annotation, long balitaRecordId);

    boolean approveBalitaRecord(long balitaRecordId);

    boolean createBalitaRecord(BalitaRecordDto request);

    boolean createExternalBalitaRecord(ExternalBalitaRecordDto request);

    List<BalitaRecordDto> getBalitaRecords(long balitaId, int pageNo);

    List<BalitaRecordDto> getAllBalitaRecords(long balitaId);


    Map<String, Integer> getBalitaRecordsByMonth(long bidanId);

    int getTotalPage(int pageNo, long balitaId);

}
