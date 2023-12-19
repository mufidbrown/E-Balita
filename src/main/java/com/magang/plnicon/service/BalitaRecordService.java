package com.magang.plnicon.service;


import com.magang.plnicon.dto.BalitaRecordDTO;

import java.util.List;
import java.util.Map;

public interface BalitaRecordService {

	public BalitaRecordDTO save(BalitaRecordDTO balitaRecordDTO);
    public BalitaRecordDTO update(BalitaRecordDTO balitaRecordDTO, long vId) throws Exception;
	public BalitaRecordDTO getById(long vId) throws Exception;
	public List<BalitaRecordDTO> getAll();
	public Map<String, Boolean> delete(long vId) throws Exception;

}
