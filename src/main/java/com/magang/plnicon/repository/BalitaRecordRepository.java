package com.magang.plnicon.repository;


import com.magang.plnicon.entity.BalitaRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalitaRecordRepository extends JpaRepository<BalitaRecord,Long> {
    @Override
    BalitaRecord getById(Long aLong);
}
