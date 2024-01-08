package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Imunisasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImunisasiRepository extends JpaRepository<Imunisasi, Integer> {
}
