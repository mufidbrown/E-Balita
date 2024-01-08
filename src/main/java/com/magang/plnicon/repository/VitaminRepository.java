package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Vitamin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitaminRepository extends JpaRepository<Vitamin, Integer> {
}
