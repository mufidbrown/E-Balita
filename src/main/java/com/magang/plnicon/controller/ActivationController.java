package com.magang.plnicon.controller;


import com.magang.plnicon.payload.request.ActivationRequest;
import com.magang.plnicon.payload.request.ApprovalRequest;
import com.magang.plnicon.service.ActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activation")
public class ActivationController {

    @Autowired
    private ActivationService activationService;

    @PostMapping("/request-activation")
    public void requestActivation(@RequestBody ActivationRequest activationRequest) {
        activationService.requestActivation(activationRequest.getUsername(), activationRequest.getEmail());
    }

    @PostMapping("/approve-activation")
    public void approveActivation(@RequestBody ApprovalRequest approvalRequest) {
        activationService.approveActivation(approvalRequest.getUserId());
    }
}
