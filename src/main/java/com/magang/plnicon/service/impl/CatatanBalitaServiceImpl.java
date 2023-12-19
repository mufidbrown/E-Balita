//package com.magang.plnicon.service.impl;
//
//import com.magang.plnicon.entity.CatatanBalita;
//import com.magang.plnicon.repository.CatatanBalitaRepository;
//import com.magang.plnicon.service.CatatanBalitaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//
//@Service
//public class CatatanBalitaServiceImpl implements CatatanBalitaService {
//
//    private final CatatanBalitaRepository catatanBalitaRepository;
//
//    @Autowired
//    public CatatanBalitaServiceImpl(CatatanBalitaRepository catatanBalitaRepository) {
//        this.catatanBalitaRepository = catatanBalitaRepository;
//    }
//
//
//    @Override
//    public CatatanBalita saveCatatanBalita(CatatanBalita catatanBalita) {
//        return catatanBalitaRepository.save(catatanBalita);
//    }
//
//    @Override
//    public CatatanBalita getCatatanBalitaById(Long id) {
//        return catatanBalitaRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<CatatanBalita> getAllCatatanBalita() {
//        return catatanBalitaRepository.findAll();
//    }
//
//    @Override
//    public List<CatatanBalita> getCatatanBalitaByTanggal(Date tanggal) {
//        return null;
//    }
//
//    @Override
//    public void deleteCatatanBalita(Long id) {
//        catatanBalitaRepository.deleteById(id);
//    }
//
////    private final CatatanBalitaRepository catatanBalitaRepository;
////
////    @Autowired
////    public CatatanBalitaServiceImpl(CatatanBalitaRepository catatanBalitaRepository) {
////        this.catatanBalitaRepository = catatanBalitaRepository;
////    }
////
////    @Override
////    public CatatanBalita saveCatatanBalita(CatatanBalita catatanBalita) {
////        return catatanBalitaRepository.save(catatanBalita);
////    }
////
////
////    public CatatanBalita getCatatanBalitaById(Long id) {
////        return catatanBalitaRepository.findById(id).orElse(null);
////    }
////
////    @Override
////    public List<CatatanBalita> getAllCatatanBalita() {
////        return catatanBalitaRepository.findAll();
////    }
////
////    @Override
////    public List<CatatanBalita> getBalitaRecordsByTanggal(Date tanggal) {
////        return null; // Ganti dengan logika pencarian yang sesuai
////    }
////
////    @Override
////    public void deleteCatatanBalita(Long id) {
////        catatanBalitaRepository.deleteById(id);
////    }
//
//}
