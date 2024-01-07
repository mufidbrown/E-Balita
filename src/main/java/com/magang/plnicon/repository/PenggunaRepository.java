package com.magang.plnicon.repository;

import com.magang.plnicon.payload.request.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Integer> {
}