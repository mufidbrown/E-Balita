package com.magang.plnicon.service.impl;

import com.magang.plnicon.service.ApprovalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {

        private String pending;
        private String approved;
        private String rejected;

        @Override
        public String getPendingStatus() {
            if (pending != null) {
                return pending;
            } else {
                return "Pending status is not set";
            }
        }

        @Override
        public String getApprovedStatus() {
            if (approved != null) {
                return approved;
            } else {
                return "Approved status is not set";
            }
        }

        @Override
        public String getRejectedStatus() {
            if (rejected != null) {
                return rejected;
            } else {
                return "Rejected status is not set";
            }
        }

        @Override
        public void setPendingStatus(String pending) {
            if (pending != null && !pending.isEmpty()) {
                this.pending = pending;
            } else {
                // Handle invalid input or empty string
                // You can throw an exception or handle it based on your application's logic
            }
        }

        @Override
        public void setApprovedStatus(String approved) {
            if (approved != null && !approved.isEmpty()) {
                this.approved = approved;
            } else {
                // Handle invalid input or empty string
            }
        }

        @Override
        public void setRejectedStatus(String rejected) {
            if (rejected != null && !rejected.isEmpty()) {
                this.rejected = rejected;
            } else {
                // Handle invalid input or empty string
            }
        }

        @Override
        public List<String> getAllStatus() {
            List<String> allStatus = new ArrayList<>();
            allStatus.add(getPendingStatus());
            allStatus.add(getApprovedStatus());
            allStatus.add(getRejectedStatus());
            return allStatus;
        }
}
