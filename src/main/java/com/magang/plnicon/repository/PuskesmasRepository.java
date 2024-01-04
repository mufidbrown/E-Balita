package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Puskesmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuskesmasRepository extends JpaRepository<Puskesmas, Integer> {
}
