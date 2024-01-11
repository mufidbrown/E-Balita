package com.magang.plnicon.service;

import com.magang.plnicon.entity.Request;

import java.util.List;

public interface RequestService {
    List<Request> getPendingRequests();
    Request acceptRequest(Integer requestId);
    Request rejectRequest(Integer requestId);
    Request createRequest(Request request);
    List<Request> getAllRequest();

}

