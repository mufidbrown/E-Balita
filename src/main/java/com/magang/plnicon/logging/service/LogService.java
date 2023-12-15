package com.magang.plnicon.logging.service;

import com.magang.plnicon.logging.entity.LogEntity;

/**
 * Service interface for saving {@link LogEntity} to the database.
 */
public interface LogService {
    void saveLogToDatabase(LogEntity logEntity);
}
