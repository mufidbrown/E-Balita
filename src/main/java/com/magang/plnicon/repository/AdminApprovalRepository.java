package com.magang.plnicon.repository;

import com.magang.plnicon.entity.AdminApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminApprovalRepository extends JpaRepository<AdminApproval, Long> {

    AdminApproval findById(Integer userId);
    
}
