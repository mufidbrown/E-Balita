package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KnowledgeRepository extends JpaRepository<Knowledge, Integer> {
    Optional<Knowledge> findByName(String fileName);

}
