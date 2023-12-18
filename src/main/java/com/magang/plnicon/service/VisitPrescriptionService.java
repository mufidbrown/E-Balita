package com.magang.plnicon.service;


import com.magang.plnicon.dto.VisitPrescriptionDTO;

import java.util.List;
import java.util.Map;

public interface VisitPrescriptionService {

	public VisitPrescriptionDTO save(VisitPrescriptionDTO visitPrescriptionDTO);
    public VisitPrescriptionDTO update(VisitPrescriptionDTO visitPrescriptionDTO, long vId) throws Exception;
	public VisitPrescriptionDTO getById(long vId) throws Exception;
	public List<VisitPrescriptionDTO> getAll();
	public Map<String, Boolean> delete(long vId) throws Exception;

}
