package com.magang.plnicon.repository;

import com.magang.plnicon.entity.BalitaRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BalitaRecordRepository extends JpaRepository<BalitaRecord, Long> {

    Optional<BalitaRecord> findFirstByBalitaBalitaIdOrderByDateCreatedDesc(@Param("balitaId") long balitaId);

    Page<BalitaRecord> findByBalitaBalitaId(Long balitaId, Pageable pageable);

    List<BalitaRecord> findByBalitaBalitaId(Long balitaId);

    int countByDateCreatedAndBalitaBidanBidanId(LocalDate createdAt, long bidanId);

    int countByDateCreatedBetweenAndBalitaBidanBidanId(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("bidanId") Long bidanId);
}
