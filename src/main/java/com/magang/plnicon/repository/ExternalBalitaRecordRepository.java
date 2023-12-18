package com.magang.plnicon.repository;

import com.magang.plnicon.entity.ExternalBalitaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExternalBalitaRecordRepository extends JpaRepository<ExternalBalitaRecord, Long>  {
}



