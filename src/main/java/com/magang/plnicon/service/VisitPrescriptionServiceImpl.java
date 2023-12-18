package com.magang.plnicon.service;


import com.magang.plnicon.dto.VisitPrescriptionDTO;
import com.magang.plnicon.entity.VisitPrescription;
import com.magang.plnicon.repository.VisitPrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VisitPrescriptionServiceImpl implements VisitPrescriptionService{

	@Autowired
	private VisitPrescriptionRepository vRepo;

	private VisitPrescription convertDTOtoModel(VisitPrescriptionDTO visitPrescriptionDTO) {

		VisitPrescription visitPrescription = new VisitPrescription();

		visitPrescription.setBidan(visitPrescriptionDTO.getBidan());
		visitPrescription.setBalita(visitPrescriptionDTO.getBalita());
		visitPrescription.setvName(visitPrescriptionDTO.getvName());
		visitPrescription.setvBidanAdvices(visitPrescriptionDTO.getvBidanAdvices());
		visitPrescription.setVId(visitPrescriptionDTO.getvId());
		visitPrescription.setvDate(visitPrescriptionDTO.getvDate());

		return visitPrescription;
	}

	/*
	 * Convert Model To DTO
	 */
	private VisitPrescriptionDTO convertModelToDTO(VisitPrescription visitPrescription) {
		return new VisitPrescriptionDTO(visitPrescription);
	}

	@Override
	public VisitPrescriptionDTO save(VisitPrescriptionDTO visitPrescriptionDTO){
		VisitPrescription visitPrescription = convertDTOtoModel(visitPrescriptionDTO);
		vRepo.save(visitPrescription);
		return convertModelToDTO(visitPrescription);
	}

	@Override
	public VisitPrescriptionDTO update(VisitPrescriptionDTO visitPrescriptionDTO, long vId) throws Exception {
		VisitPrescriptionDTO cpyVisitPrescription = getById(vId);

		cpyVisitPrescription.setBalita(visitPrescriptionDTO.getBalita());
		cpyVisitPrescription.setvDate(visitPrescriptionDTO.getvDate());
		cpyVisitPrescription.setvName(visitPrescriptionDTO.getvName());
		cpyVisitPrescription.setBidan(visitPrescriptionDTO.getBidan());
		cpyVisitPrescription.setvBidanAdvices(visitPrescriptionDTO.getvBidanAdvices());

		VisitPrescription visitPrescription = convertDTOtoModel(cpyVisitPrescription);
		vRepo.save(visitPrescription);
		return convertModelToDTO(visitPrescription);
	}

	@Override
	public VisitPrescriptionDTO getById(long vId) throws Exception {
		VisitPrescription visitPrescription = vRepo.findById(vId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + vId));
		return convertModelToDTO(visitPrescription);
	}

	@Override
	public List<VisitPrescriptionDTO> getAll(){
		List<VisitPrescription> visitPrescriptionList = vRepo.findAll();
		List<VisitPrescriptionDTO> visitPrescriptionDTOList = new ArrayList<>();

		for(VisitPrescription visitPrescription : visitPrescriptionList) {
			visitPrescriptionDTOList.add(convertModelToDTO(visitPrescription));
		}
		return visitPrescriptionDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long vId) throws Exception{
		VisitPrescription visitPrescription = convertDTOtoModel(getById(vId));

		vRepo.delete(visitPrescription);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);

		return response;
	}


}
