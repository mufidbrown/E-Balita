package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.master.Knowledge;
import com.magang.plnicon.repository.KnowledgeRepository;
import com.magang.plnicon.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    @Autowired
    public KnowledgeServiceImpl(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
    }

    @Override
    public List<Knowledge> getAllKnowledge() {
        List<Knowledge> allKnowledge = knowledgeRepository.findAll();
        if (!allKnowledge.isEmpty()) {
            return allKnowledge;
        } else {
            throw new IllegalArgumentException("Knowledge tidak ditemukan didalam database");
        }
    }


    @Override
    public Knowledge getKnowledgeById(Integer id) {
        if (id != null) {
            Optional<Knowledge> knowledgeOptional = knowledgeRepository.findById(id);
            if (knowledgeOptional.isPresent()) {
                return knowledgeOptional.get();
            } else {
                throw new IllegalArgumentException("Knowledge dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public Knowledge createKnowledge(Knowledge knowledge) {
        if (knowledge.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Knowledge dengan ID yang sudah ditentukan");
        } else {
            return knowledgeRepository.save(knowledge);
        }
    }

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


    @Override
    public void deleteKnowledge(Integer id) {
        Optional<Knowledge> existingKnowledgeOptional = knowledgeRepository.findById(id);
        if (existingKnowledgeOptional.isPresent()) {
            knowledgeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Knowledge dengan ID " + id + " tidak ditemukan");
        }
    }

}




/*    @Override
    public Knowledge updateKnowledge(Integer id, Knowledge newKnowledge) {
        Optional<Knowledge> existingKnowledgeOptional = knowledgeRepository.findById(id);
        if (existingKnowledgeOptional.isPresent()) {
            Knowledge existingKnowledge = existingKnowledgeOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingKnowledge.setTopik(newKnowledge.getTopik());
            existingKnowledge.setKeterangan(newKnowledge.getKeterangan());
            existingKnowledge.setDeskripsi(newKnowledge.getDeskripsi());

            return knowledgeRepository.save(existingKnowledge);
        }
        return null;
    }*/



//    @Override
//    public void deleteKnowledge(Integer id) {
//        Optional<Knowledge> existingKnowledgeOptional = knowledgeRepository.findById(id);
//        if (existingKnowledgeOptional.isEmpty()) {
//            throw new EntityNotFoundException("Knowledge dengan ID " + id + " tidak ditemukan");
//            // Atau Anda bisa menentukan penanganan kesalahan yang sesuai
//        }
//        knowledgeRepository.deleteById(id);
//    }

