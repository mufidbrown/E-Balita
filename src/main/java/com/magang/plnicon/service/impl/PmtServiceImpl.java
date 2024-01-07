package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Pmt;
import com.magang.plnicon.repository.PmtRepository;
import com.magang.plnicon.service.PmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PmtServiceImpl implements PmtService {

    private final PmtRepository pmtRepository;

    @Autowired
    public PmtServiceImpl(PmtRepository pmtRepository) {
          this.pmtRepository = pmtRepository;
    }


    @Override
    public List<Pmt> getAllPmt() {
        List<Pmt> allPmt = pmtRepository.findAll();
        if (!allPmt.isEmpty()) {
            return allPmt;
        } else {
            throw new IllegalArgumentException("Pmt tidak ditemukan didalam database");
        }
    }


    @Override
    public Pmt getPmtById(Integer id) {
        if (id != null) {
            Optional<Pmt> pmtOptional = pmtRepository.findById(id);
            if (pmtOptional.isPresent()) {
                return pmtOptional.get();
            } else {
                throw new IllegalArgumentException("Pmt dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public Pmt createPmt(Pmt pmt) {
        if (pmt.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Puskesmas dengan ID yang sudah ditentukan");
        } else {
            return pmtRepository.save(pmt);
        }
    }



    @Override
    public Pmt updatePmt(Integer id, Pmt newPmt) {
        Optional<Pmt> existingPmtOptional = pmtRepository.findById(id);
        if (existingPmtOptional.isPresent()) {
            Pmt existingPmt = existingPmtOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingPmt.setMakanan_pmt(newPmt.getMakanan_pmt());
            existingPmt.setKalori_pmt(newPmt.getKalori_pmt());
            existingPmt.setKeterangan(newPmt.getKeterangan());
            existingPmt.setStatus(newPmt.getStatus());

            return pmtRepository.save(existingPmt);
        }
        return null;
    }

    @Override
    public void deletePmt(Integer id) {
        if (pmtRepository.existsById(id)) {
            pmtRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pmt dengan ID " + id + " tidak ditemukan");
        }
    }


//    @Override
//    public void deletePmt(Integer id) {
//        Optional<Pmt> existingPmtOptional = pmtRepository.findById(id);
//        if (existingPmtOptional.isEmpty()) {
//            throw new EntityNotFoundException("Puskesmas dengan ID " + id + " tidak ditemukan");
//            // Atau Anda bisa menentukan penanganan kesalahan yang sesuai
//        }
//        pmtRepository.deleteById(id);
//    }

}

/*

ini digunakan untuk update PMT serviceimpl
    @Override
    public Knowledge updateKnowledge(Integer id, Knowledge newKnowledge) {
        Optional<Knowledge> existingKnowledgeOptional = knowledgeRepository.findById(id);
        if (existingKnowledgeOptional.isPresent()) {
            Knowledge existingKnowledge = existingKnowledgeOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingKnowledge.setTopik(newKnowledge.getTopik());
            existingKnowledge.setKeterangan(newKnowledge.getKeterangan());
            existingKnowledge.setDeskripsi(newKnowledge.getDeskripsi());

            return knowledgeRepository.save(existingKnowledge);
        } else {
            throw new EntityNotFoundException("Knowledge dengan ID " + id + " tidak ditemukan");
        }
    }
*/


//    @Override
//    public void deletePmt(Integer id) {
//        Optional<Pmt> existingPmtOptional = pmtRepository.findById(id);
//        if (!existingPmtOptional.isPresent()) {
//            throw new EntityNotFoundException("Puskesmas dengan ID " + id + " tidak ditemukan");
//            // Atau Anda bisa menentukan penanganan kesalahan yang sesuai
//        }
//        pmtRepository.deleteById(id);
//    }
