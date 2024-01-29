package com.magang.plnicon.controller;


import com.magang.plnicon.entity.Request;
import com.magang.plnicon.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/requests")
public class RequestController {

        @Autowired
        private RequestService requestService;


        @GetMapping("/all")
        @PreAuthorize("hasAuthority('ROLE_AHLI_GIZI')")
        public ResponseEntity<?> getAllRequest() {
            List<Request> allRequest = requestService.getAllRequest();
            if (!allRequest.isEmpty()) {
                return ResponseEntity.ok(allRequest);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada Request yang ditemukan");
            }
        }


    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_AHLI_GIZI')")
    public ResponseEntity<?> createRequest(@RequestBody Request request) {
        if (request != null) {
            try {
                Request createdRequest = requestService.createRequest(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat Request: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request input");
        }
    }

        @GetMapping("/pending")
        @PreAuthorize("hasAuthority('ROLE_AHLI_GIZI')")
        public List<Request> getPendingRequests() {
            return requestService.getPendingRequests();
        }

        @PutMapping("/accept/{requestId}")
        @PreAuthorize("hasAuthority('ROLE_AHLI_GIZI')")
        public ResponseEntity<String> acceptRequest(@PathVariable Integer requestId) {
            Request acceptedRequest = requestService.acceptRequest(requestId);
            if (acceptedRequest != null) {
                return ResponseEntity.ok("Permintaan dengan ID " + requestId + " has been accepted.");
            } else {
                return ResponseEntity.badRequest().body("Tidak dapat menerima permintaan dengan ID " + requestId);
            }
        }

        @PutMapping("/reject/{requestId}")
        @PreAuthorize("hasAuthority('ROLE_AHLI_GIZI')")
        public ResponseEntity<String> rejectRequest(@PathVariable Integer requestId) {
            Request rejectedRequest = requestService.rejectRequest(requestId);
            if (rejectedRequest != null) {
                return ResponseEntity.ok("Permintaan dengan ID " + requestId + " ditolak.");
            } else {
                return ResponseEntity.badRequest().body("Tidak dapat menolak permintaan dengan ID " + requestId);
            }
        }
    }
