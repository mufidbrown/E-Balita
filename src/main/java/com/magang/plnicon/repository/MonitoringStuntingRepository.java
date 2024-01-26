package com.magang.plnicon.repository;

import com.magang.plnicon.entity.MonitoringStunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringStuntingRepository extends JpaRepository<MonitoringStunting, Integer> {
}
