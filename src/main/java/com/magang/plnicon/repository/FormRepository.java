package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Form;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Long> {
    Optional<Form> findById(Long id);
    Page<Form> findAllByApprover1(Pageable pageable, String approver1);
    Page<Form> findAllByApprover2(Pageable pageable, String approver2);
    List<Form> findAllByApprover1(String approver1);
    List<Form> findAllByApprover2(String approver2);
    List<Form> findAllByStatus(String status);
    Optional<Form> findByTrackingId(String trackingId);

    //Query Searches
    List<Form> findByName(String name);
    List<Form> findByLastName(String lastName);
    List<Form> findByEmailContaining(String email);
    List<Form> findByLastNameAndName(String lastName, String name);
    List<Form> findByYuid(String yuid);
}