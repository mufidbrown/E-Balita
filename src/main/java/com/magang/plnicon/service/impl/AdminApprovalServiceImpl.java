//package com.magang.plnicon.service.impl;
//
//
//import com.magang.plnicon.entity.AdminApproval;
//import com.magang.plnicon.repository.AdminApprovalRepository;
//import com.magang.plnicon.service.AdminApprovalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AdminApprovalServiceImpl implements AdminApprovalService {
//
//    @Autowired
//    private AdminApprovalRepository adminApprovalRepository;
//
//    @Override
//    public void saveApproval(AdminApproval approval) {
//        adminApprovalRepository.save(approval);
//    }
//
//    @Override
//    public void approveActivation(Integer userId) {
//        // Implementasi persetujuan admin
//        AdminApproval approval = adminApprovalRepository.findByUserId(userId);
//        if (approval != null && !approval.isApproved()) {
//            // Lakukan persetujuan
//            approval.setApproved(true);
//            adminApprovalRepository.save(approval);
//        }
//    }
//
//    @Override
//    public AdminApproval getApprovalByUserId(Integer userId) {
//        // Mendapatkan entri persetujuan admin berdasarkan userId
//        return adminApprovalRepository.findByUserId(userId);
//    }
//
//    @Override
//    public List<AdminApproval> getAllPendingApprovals() {
//        // Mendapatkan semua entri persetujuan yang belum disetujui
//        return adminApprovalRepository.findAllByApprovedFalse();
//    }
//
//}
//
//
