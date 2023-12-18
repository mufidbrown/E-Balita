package com.magang.plnicon.service.impl;


import com.magang.plnicon.entity.BalitaRecord;
import com.magang.plnicon.exception.BalitaRecordException;
import com.magang.plnicon.repository.BalitaRecordRepository;
import com.magang.plnicon.repository.ExternalBalitaRecordRepository;
import com.magang.plnicon.service.BalitaRecordService;
import com.magang.plnicon.util.BalitaRecordConvertor;
import com.magang.plnicon.util.ExternalBalitaRecordConvertor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BalitaRecordServiceImpl implements BalitaRecordService {

    private final BalitaRecordRepository balitaRecordRepository;
    private final ExternalBalitaRecordRepository externalMedicalRecordRepository;
    private final BalitaRecordConvertor balitaRecordConvertor;
    private final ExternalBalitaRecordConvertor externalBalitaRecordConvertor;

    @Override
    public BalitaRecord getRecentBalitaRecord(long balitaId) {
        Optional<BalitaRecord> balitaRecord =
                balitaRecordRepository.findFirstByBalitaBalitaIdOrderByDateCreatedDesc(balitaId);
        if (balitaRecord.isPresent()){
            return balitaRecord.get();
        }
        throw new BalitaRecordException("This patient does not have any records");
    }

}
