package com.magang.plnicon.repository;

import com.magang.plnicon.entity.TumbuhKembang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TumbuhKembangRepository extends JpaRepository<TumbuhKembang, Integer> {
}
