package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Balita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BalitaRepository extends JpaRepository<Balita, Integer> {
}
