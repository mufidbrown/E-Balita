package com.magang.plnicon.repository;

import com.magang.plnicon.entity.master.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Integer> {
}
