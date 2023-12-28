package com.magang.plnicon.repository;

import com.magang.plnicon.entity.ApprovalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalRepository extends  JpaRepository<ApprovalUser, Integer>{
}
