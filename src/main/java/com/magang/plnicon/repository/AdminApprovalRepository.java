package com.magang.plnicon.repository;

import com.magang.plnicon.entity.AdminApproval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminApprovalRepository extends JpaRepository<AdminApproval, Long> {

    AdminApproval findById(Integer userId);

    AdminApproval findByUserId(Integer userId);

    List<AdminApproval> findAllByApprovedFalse();
}
