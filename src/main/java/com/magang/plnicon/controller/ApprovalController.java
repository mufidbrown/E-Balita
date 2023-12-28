package com.magang.plnicon.controller;

import com.magang.plnicon.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approval")
public class ApprovalController {

    private final ApprovalService approvalService;

    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping("/pending")
    public ResponseEntity<String> getPendingStatus() {
        String pendingStatus = approvalService.getPendingStatus();
        if (pendingStatus != null) {
            return ResponseEntity.ok(pendingStatus);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pending status is not set");
        }
    }

    @GetMapping("/approved")
    public ResponseEntity<String> getApprovedStatus() {
        String approvedStatus = approvalService.getApprovedStatus();
        if (approvedStatus != null) {
            return ResponseEntity.ok(approvedStatus);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Approved status is not set");
        }
    }

    @GetMapping("/rejected")
    public ResponseEntity<String> getRejectedStatus() {
        String rejectedStatus = approvalService.getRejectedStatus();
        if (rejectedStatus != null) {
            return ResponseEntity.ok(rejectedStatus);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rejected status is not set");
        }
    }
    
}
