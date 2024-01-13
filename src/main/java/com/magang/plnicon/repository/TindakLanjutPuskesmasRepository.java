package com.magang.plnicon.repository;

import com.magang.plnicon.entity.TindakLanjutPuskesmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TindakLanjutPuskesmasRepository extends JpaRepository<TindakLanjutPuskesmas, Integer> {
}
