package com.magang.plnicon.repository;

import com.magang.plnicon.entity.LaporanBalita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaporanBalitaRepository extends JpaRepository<LaporanBalita, Integer> {
}
