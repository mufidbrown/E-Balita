package com.magang.plnicon.service;

import java.util.List;

public interface ApprovalService {

        String getPendingStatus();

        String getApprovedStatus();

        String getRejectedStatus();

        void setPendingStatus(String pending);

        void setApprovedStatus(String approved);

        void setRejectedStatus(String rejected);

        List<String> getAllStatus(); // Jika Anda ingin mendapatkan semua status dalam bentuk list

}





