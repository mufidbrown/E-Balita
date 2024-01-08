package com.magang.plnicon.repository;

import com.magang.plnicon.entity.master.Pmt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PmtRepository extends JpaRepository<Pmt, Integer> {
}
