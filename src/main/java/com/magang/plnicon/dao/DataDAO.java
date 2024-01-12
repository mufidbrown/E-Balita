package com.magang.plnicon.dao;

import com.magang.plnicon.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataDAO extends JpaRepository<Data, Integer> {
}
