package com.magang.plnicon.service;

import com.magang.plnicon.entity.Knowledge;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface KnowledgeService {


    List<Knowledge> getAllKnowledge();
    Knowledge getKnowledgeById(Integer id);
    Knowledge createKnowledge(Knowledge knowledge);
    Knowledge updateKnowledge(Integer id, Knowledge knowledge);
    void deleteKnowledge(Integer id);

    Knowledge uploadImage(MultipartFile file) throws IOException;
}
