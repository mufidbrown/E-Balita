package com.magang.plnicon.repository;

import com.magang.plnicon.entity.Request;
import com.magang.plnicon.entity.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> findByStatus(RequestStatus status);
}

