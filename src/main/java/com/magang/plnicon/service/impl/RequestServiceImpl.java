package com.magang.plnicon.service.impl;


import com.magang.plnicon.entity.Request;
import com.magang.plnicon.entity.RequestStatus;
import com.magang.plnicon.repository.RequestRepository;
import com.magang.plnicon.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> getAllRequest() {
        List<Request> allRequest = requestRepository.findAll();
        if (!allRequest.isEmpty()) {
            return allRequest;
        } else {
            throw new IllegalArgumentException("Daftar Request kosong");
        }
    }

    @Override
    public Request createRequest(String description) {
        Request request = new Request();
        request.setDescription(description);
        request.setStatus(RequestStatus.PENDING);
        return requestRepository.save(request);
    }

    @Override
    public List<Request> getPendingRequests() {
        return requestRepository.findByStatus(RequestStatus.PENDING);
    }

    @Override
    public Request acceptRequest(Integer requestId) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setStatus(RequestStatus.ACCEPTED);
            // Perform necessary actions upon acceptance
            // Any additional logic can be added here

            return requestRepository.save(request);
        }
        return null;
    }

    @Override
    public Request rejectRequest(Integer requestId) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setStatus(RequestStatus.REJECTED);
            // Perform necessary actions upon rejection
            // Any additional logic can be added here

            return requestRepository.save(request);
        }
        return null;
    }
}
