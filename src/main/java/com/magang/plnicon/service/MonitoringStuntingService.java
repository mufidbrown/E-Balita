package com.magang.plnicon.service;

import com.magang.plnicon.entity.MonitoringStunting;

import java.util.List;

public interface MonitoringStuntingService {



    List<MonitoringStunting> getAllMonitoringStunting();
    MonitoringStunting getMonitoringStuntingById(Integer id);
    MonitoringStunting createMonitoringStunting(MonitoringStunting monitoringStunting);
    MonitoringStunting updateMonitoringStunting(Integer id, MonitoringStunting MonitoringStunting);
    void deleteMonitoringStunting(Integer id);

}
