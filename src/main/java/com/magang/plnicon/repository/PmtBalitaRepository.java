package com.magang.plnicon.repository;

import com.magang.plnicon.entity.balita.PmtBalita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PmtBalitaRepository extends JpaRepository<PmtBalita, Integer> {
}
