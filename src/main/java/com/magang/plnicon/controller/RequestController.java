package com.magang.plnicon.controller;


import com.magang.plnicon.entity.Request;
import com.magang.plnicon.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/requests")
public class RequestController {

        @Autowired
        private RequestService requestService;


        @GetMapping("/all")
        public ResponseEntity<?> getAllRequest() {
            List<Request> allRequest = requestService.getAllRequest();
            if (!allRequest.isEmpty()) {
                return ResponseEntity.ok(allRequest);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada Request yang ditemukan");
            }
        }


        @PostMapping("/create")
        public ResponseEntity<String> createRequest(@RequestParam String description) {
            Request createdRequest = requestService.createRequest(description);
            if (createdRequest != null) {
                return ResponseEntity.ok("Permintaan dibuat dengan ID: " + createdRequest.getId());
            } else {
                return ResponseEntity.badRequest().body("Gagal membuat permintaan.");
            }
        }

        @GetMapping("/pending")
        public List<Request> getPendingRequests() {
            return requestService.getPendingRequests();
        }

        @PutMapping("/accept/{requestId}")
        public ResponseEntity<String> acceptRequest(@PathVariable Integer requestId) {
            Request acceptedRequest = requestService.acceptRequest(requestId);
            if (acceptedRequest != null) {
                return ResponseEntity.ok("Permintaan dengan ID " + requestId + " has been accepted.");
            } else {
                return ResponseEntity.badRequest().body("Tidak dapat menerima permintaan dengan ID " + requestId);
            }
        }

        @PutMapping("/reject/{requestId}")
        public ResponseEntity<String> rejectRequest(@PathVariable Integer requestId) {
            Request rejectedRequest = requestService.rejectRequest(requestId);
            if (rejectedRequest != null) {
                return ResponseEntity.ok("Permintaan dengan ID " + requestId + " ditolak.");
            } else {
                return ResponseEntity.badRequest().body("Tidak dapat menolak permintaan dengan ID " + requestId);
            }
        }
    }
