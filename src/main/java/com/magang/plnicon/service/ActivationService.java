package com.magang.plnicon.service;


import com.magang.plnicon.entity.AdminApproval;
import com.magang.plnicon.entity.User;
import com.magang.plnicon.repository.AdminApprovalRepository;
import com.magang.plnicon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminApprovalRepository adminApprovalRepository;

    public void requestActivation(String username, String email) {
        // Simpan data user yang belum aktif
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setActive(false);
        userRepository.save(user);

        // Buat entri persetujuan admin
        AdminApproval approval = new AdminApproval();
        approval.setUserId(user.getId());
        approval.setApproved(false);
        adminApprovalRepository.save(approval);
    }

    public void approveActivation(Integer userId) {
        // Setujui akun user
        User user = userRepository.getById(userId);
        user.setActive(true);
        userRepository.save(user);

        // Update status persetujuan admin
        AdminApproval approval = adminApprovalRepository.findByUserId(userId);
        approval.setApproved(true);
        adminApprovalRepository.save(approval);
    }
}
