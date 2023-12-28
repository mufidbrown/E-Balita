package com.magang.plnicon.controller;

import com.magang.plnicon.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approval")
public class ApprovalController {

    private final ApprovalService approvalService;

    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @PostMapping("/pending")
    public ResponseEntity<String> setPendingStatus(@RequestBody String pending) {
        if (pending != null && !pending.isEmpty()) {
            approvalService.setPendingStatus(pending);
            return ResponseEntity.ok("Pending status has been set");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input or empty string for pending status");
        }
    }

    @PostMapping("/approved")
    public ResponseEntity<String> setApprovedStatus(@RequestBody String approved) {
        if (approved != null && !approved.isEmpty()) {
            approvalService.setApprovedStatus(approved);
            return ResponseEntity.ok("Approved status has been set");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input or empty string for approved status");
        }
    }

    @PostMapping("/rejected")
    public ResponseEntity<String> setRejectedStatus(@RequestBody String rejected) {
        if (rejected != null && !rejected.isEmpty()) {
            approvalService.setRejectedStatus(rejected);
            return ResponseEntity.ok("Rejected status has been set");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input or empty string for rejected status");
        }
    }

    @GetMapping("/allStatus")
    public ResponseEntity<List<String>> getAllStatus() {
        List<String> allStatus = approvalService.getAllStatus();
        return ResponseEntity.ok(allStatus);
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
