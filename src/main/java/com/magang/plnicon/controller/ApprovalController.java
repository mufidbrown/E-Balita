package com.magang.plnicon.controller;

import com.magang.plnicon.entity.Approval;
import com.magang.plnicon.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping
    public ResponseEntity<List<Approval>> getAllApprovals() {
        List<Approval> approvals = approvalService.getAllApprovals();
        return new ResponseEntity<>(approvals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable Integer id) {
        return approvalService.getApprovalById(id)
                .map(approval -> new ResponseEntity<>(approval, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Approval> createApproval(@RequestBody Approval approval) {
        Approval createdApproval = approvalService.createApproval(approval);
        return new ResponseEntity<>(createdApproval, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable Integer id, @RequestBody Approval approval) {
        Approval updatedApproval = approvalService.updateApproval(id, approval);
        return new ResponseEntity<>(updatedApproval, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable Integer id) {
        approvalService.deleteApproval(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



//import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//        import java.util.Optional;
//
//@RestController
//@RequestMapping("/approvals")
//public class ApprovalController {
//
//    private final ApprovalService approvalService;
//
//    @Autowired
//    public ApprovalController(ApprovalService approvalService) {
//        this.approvalService = approvalService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Approval>> getAllApprovals() {
//        List<Approval> approvals = approvalService.getAllApprovals();
//        if (approvals.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(approvals, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Approval> getApprovalById(@PathVariable Integer id) {
//        Optional<Approval> approval = approvalService.getApprovalById(id);
//        if (approval.isPresent()) {
//            return new ResponseEntity<>(approval.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Approval> createApproval(@RequestBody Approval approval) {
//        if (approval.getId() != null) {
//            return new ResponseEntity<>("ID must be null for new Approval", HttpStatus.BAD_REQUEST);
//        }
//        Approval createdApproval = approvalService.createApproval(approval);
//        return new ResponseEntity<>(createdApproval, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Approval> updateApproval(@PathVariable Integer id, @RequestBody Approval approval) {
//        if (!id.equals(approval.getId())) {
//            return new ResponseEntity<>("ID in path must match ID in body", HttpStatus.BAD_REQUEST);
//        }
//        Optional<Approval> existingApproval = approvalService.getApprovalById(id);
//        if (existingApproval.isPresent()) {
//            Approval updatedApproval = approvalService.updateApproval(id, approval);
//            return new ResponseEntity<>(updatedApproval, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteApproval(@PathVariable Integer id) {
//        Optional<Approval> approval = approvalService.getApprovalById(id);
//        if (approval.isPresent()) {
//            approvalService.deleteApproval(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}


