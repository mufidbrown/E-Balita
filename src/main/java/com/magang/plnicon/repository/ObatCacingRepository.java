package com.magang.plnicon.repository;

import com.magang.plnicon.entity.ObatCacing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatCacingRepository extends JpaRepository<ObatCacing, Integer> {
}
