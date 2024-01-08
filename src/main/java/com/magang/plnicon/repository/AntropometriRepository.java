package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Antropometri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntropometriRepository extends JpaRepository<Antropometri, Integer> {
}
