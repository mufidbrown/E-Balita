package com.magang.plnicon.logging.service.impl;


import com.magang.plnicon.logging.entity.LogEntity;
import com.magang.plnicon.logging.repository.LogRepository;
import com.magang.plnicon.logging.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Implementation of the {@link LogService} interface for saving log entries to the database.
 */
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    /**
     * Save a {@link LogEntity} entry to the database.
     *
     * @param logEntity The {@link LogEntity} entity to be saved.
     */
    @Override
    public void saveLogToDatabase(LogEntity logEntity) {
        logEntity.setTime(LocalDateTime.now());
        logRepository.save(logEntity);
    }
}
