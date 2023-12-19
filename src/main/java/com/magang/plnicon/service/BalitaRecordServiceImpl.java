package com.magang.plnicon.service;


import com.magang.plnicon.dto.BalitaRecordDTO;
import com.magang.plnicon.entity.BalitaRecord;
import com.magang.plnicon.repository.BalitaRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BalitaRecordServiceImpl implements BalitaRecordService {

	@Autowired
	private BalitaRecordRepository vRepo;

	private BalitaRecord convertDTOtoModel(BalitaRecordDTO balitaRecordDTO) {

		BalitaRecord balitaRecord = new BalitaRecord();

		balitaRecord.setBidan(balitaRecordDTO.getBidan());
		balitaRecord.setBalita(balitaRecordDTO.getBalita());
		balitaRecord.setvName(balitaRecordDTO.getvName());
		balitaRecord.setvBidanAdvices(balitaRecordDTO.getvBidanAdvices());
		balitaRecord.setVId(balitaRecordDTO.getvId());
		balitaRecord.setvDate(balitaRecordDTO.getvDate());

		return balitaRecord;
	}

	/*
	 * Convert Model To DTO
	 */
	private BalitaRecordDTO convertModelToDTO(BalitaRecord balitaRecord) {
		return new BalitaRecordDTO(balitaRecord);
	}

	@Override
	public BalitaRecordDTO save(BalitaRecordDTO balitaRecordDTO){
		BalitaRecord balitaRecord = convertDTOtoModel(balitaRecordDTO);
		vRepo.save(balitaRecord);
		return convertModelToDTO(balitaRecord);
	}

	@Override
	public BalitaRecordDTO update(BalitaRecordDTO balitaRecordDTO, long vId) throws Exception {
		BalitaRecordDTO cpyBalitaRecord = getById(vId);

		cpyBalitaRecord.setBalita(balitaRecordDTO.getBalita());
		cpyBalitaRecord.setvDate(balitaRecordDTO.getvDate());
		cpyBalitaRecord.setvName(balitaRecordDTO.getvName());
		cpyBalitaRecord.setBidan(balitaRecordDTO.getBidan());
		cpyBalitaRecord.setvBidanAdvices(balitaRecordDTO.getvBidanAdvices());

		BalitaRecord balitaRecord = convertDTOtoModel(cpyBalitaRecord);
		vRepo.save(balitaRecord);
		return convertModelToDTO(balitaRecord);
	}

	@Override
	public BalitaRecordDTO getById(long vId) throws Exception {
		BalitaRecord balitaRecord = vRepo.findById(vId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + vId));
		return convertModelToDTO(balitaRecord);
	}

	@Override
	public List<BalitaRecordDTO> getAll(){
		List<BalitaRecord> balitaRecordList = vRepo.findAll();
		List<BalitaRecordDTO> visitPrescriptionDTOList = new ArrayList<>();

		for(BalitaRecord balitaRecord : balitaRecordList) {
			visitPrescriptionDTOList.add(convertModelToDTO(balitaRecord));
		}
		return visitPrescriptionDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long vId) throws Exception{
		BalitaRecord balitaRecord = convertDTOtoModel(getById(vId));

		vRepo.delete(balitaRecord);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);

		return response;
	}


}
