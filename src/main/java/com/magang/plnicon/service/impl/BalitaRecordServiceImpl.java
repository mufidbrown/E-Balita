package com.magang.plnicon.service.impl;


import com.magang.plnicon.repository.BalitaRecordRepository;
import com.magang.plnicon.service.BalitaRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BalitaRecordServiceImpl implements BalitaRecordService {

    private final BalitaRecordRepository balitaRecordRepository;
    private final ExternalBalitaRecordRepository externalMedicalRecordRepository;
    private final BalitaRecordConvertor balitaRecordConvertor;
    private final ExternalBalitaRecordConvertor externalBalitaRecordConvertor;


}
