package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Approval;
import com.magang.plnicon.repository.ApprovalRepository;
import com.magang.plnicon.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    private final ApprovalRepository approvalRepository;

    @Autowired
    public ApprovalServiceImpl(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    @Override
    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    @Override
    public Optional<Approval> getApprovalById(Integer id) {
        return approvalRepository.findById(id);
    }

    @Override
    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    @Override
    public Approval updateApproval(Integer id, Approval updatedApproval) {
        Approval approval = approvalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval not found with id: " + id));

        approval.setName(updatedApproval.getName());
        approval.setStatus(updatedApproval.getStatus());

        return approvalRepository.save(approval);
    }

    @Override
    public void deleteApproval(Integer id) {
        approvalRepository.deleteById(id);
    }
}

