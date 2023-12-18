package com.magang.plnicon.repository;


import com.magang.plnicon.entity.VisitPrescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitPrescriptionRepository extends JpaRepository<VisitPrescription,Long> {
    @Override
    VisitPrescription getById(Long aLong);
}
