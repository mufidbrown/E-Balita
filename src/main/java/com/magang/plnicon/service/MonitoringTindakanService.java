package com.magang.plnicon.service;

import com.magang.plnicon.entity.MonitoringTindakan;

import java.util.List;

public interface MonitoringTindakanService {

    List<MonitoringTindakan> getAllMonitoringTindakan();
    MonitoringTindakan getMonitoringTindakanById(Integer id);
    MonitoringTindakan createMonitoringTindakan(MonitoringTindakan monitoringTindakan);
    MonitoringTindakan updateMonitoringTindakan(Integer id, MonitoringTindakan monitoringTindakan);
    void deleteMonitoringTindakan(Integer id);

}
