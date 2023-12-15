package com.magang.plnicon.logging.repository;

import com.magang.plnicon.logging.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the {@link LogEntity} class.
 */
public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
