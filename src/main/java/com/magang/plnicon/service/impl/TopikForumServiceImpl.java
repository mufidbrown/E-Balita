package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.TopikForum;
import com.magang.plnicon.repository.TopikForumRepository;
import com.magang.plnicon.service.TopikForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopikForumServiceImpl implements TopikForumService {

    private final TopikForumRepository topikForumRepository;

    @Autowired
    public TopikForumServiceImpl(TopikForumRepository topikForumRepository) {
        this.topikForumRepository = topikForumRepository;
    }

    @Override
    public List<TopikForum> getAllTopikForum() {
        List<TopikForum> allTopikForum = topikForumRepository.findAll();
        if (!allTopikForum.isEmpty()) {
            return allTopikForum;
        } else {
            throw new IllegalArgumentException("Daftar TopikForum kosong");
        }
    }

    @Override
    public TopikForum getTopikForumById(Integer id) {
        if (id != null) {
            Optional<TopikForum> topikForumOptional = topikForumRepository.findById(id);
            if (topikForumOptional.isPresent()) {
                return topikForumOptional.get();
            } else {
                throw new IllegalArgumentException("TopikForum dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("ID TopikForum tidak valid");
        }
    }

    @Override
    public TopikForum createTopikForum(TopikForum topikForum) {
        if (topikForum.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat TopikForum dengan ID yang sudah ditentukan");
        } else {
            return topikForumRepository.save(topikForum);
        }
    }

    @Override
    public TopikForum updateTopikForum(Integer id, TopikForum topikForum) {
        if (topikForumRepository.existsById(id)) {
            topikForum.setId(id); // Pastikan ID yang diset pada objek pengguna sesuai dengan ID yang ingin diperbarui
            return topikForumRepository.save(topikForum);
        } else {
            throw new IllegalArgumentException("TopikForum dengan ID " + id + " tidak ditemukan");
        }
    }

    @Override
    public void deleteTopikForum(Integer id) {
        if (topikForumRepository.existsById(id)) {
            topikForumRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("TopikForum dengan ID " + id + " tidak ditemukan");
        }
    }
}

