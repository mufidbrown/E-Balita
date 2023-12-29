package com.magang.plnicon.service;

import com.magang.plnicon.entity.Approval;

import java.util.List;
import java.util.Optional;

public interface ApprovalService {

        List<Approval> getAllApprovals();

        Optional<Approval> getApprovalById(Integer id);

        Approval createApproval(Approval approval);

        Approval updateApproval(Integer id, Approval approval);

        void deleteApproval(Integer id);

}





