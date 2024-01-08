package com.magang.plnicon.repository;

import com.magang.plnicon.entity.master.Posyandu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosyanduRepository extends JpaRepository<Posyandu, Integer> {
}
