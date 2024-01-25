package com.magang.plnicon.repository;

import com.magang.plnicon.entity.TopikForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopikForumRepository extends JpaRepository<TopikForum, Integer> {
}
