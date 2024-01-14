package com.magang.plnicon.repository;

import com.magang.plnicon.entity.MonitoringTindakan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringTindakanRepository extends JpaRepository<MonitoringTindakan, Integer> {
}
