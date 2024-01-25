package com.magang.plnicon.service;

import com.magang.plnicon.entity.TopikForum;

import java.util.List;

public interface TopikForumService {

    List<TopikForum> getAllTopikForum();
    TopikForum getTopikForumById(Integer id);
    TopikForum createTopikForum(TopikForum topikForum);
    TopikForum updateTopikForum(Integer id, TopikForum topikForum);
    void deleteTopikForum(Integer id);

}
