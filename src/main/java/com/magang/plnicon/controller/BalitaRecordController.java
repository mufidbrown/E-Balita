package com.magang.plnicon.controller;

import com.magang.plnicon.dto.BalitaRecordDTO;
import com.magang.plnicon.service.BalitaRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class BalitaRecordController {

    @Autowired
    private BalitaRecordServiceImpl balitaRecordService;

    //ini tambahan dari BalitaRecord, logika ne digawe ngene wae. dan BalitaRecord sing mempunyai hak akses penuh adalah BIDAN
    @PostMapping(value = "/balitaRecord")
    @PreAuthorize("hasAuthority('ROLE_BIDAN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BalitaRecordDTO> addBalitaRecord(@RequestBody BalitaRecordDTO balitaRecordDTO) {

        BalitaRecordDTO balitaRecordDTO1 = balitaRecordService.save(balitaRecordDTO);
        return ResponseEntity.ok().body(balitaRecordDTO1);
    }


    @GetMapping(value = "/balitaRecord/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_BIDAN','ROLE_ORANG_TUA')")
    public ResponseEntity<BalitaRecordDTO> findById(@PathVariable long id) throws Exception {

        BalitaRecordDTO balitaRecordDTO = balitaRecordService.getById(id);
        return ResponseEntity.ok().body(balitaRecordDTO);
    }

    @PutMapping(value = "/balitaRecord/{id}")
    @PreAuthorize("hasAuthority('ROLE_BIDAN')")
    public ResponseEntity<BalitaRecordDTO> updateBalitaRecord(@RequestBody BalitaRecordDTO balitaRecordDTO, @PathVariable("id") long id)
            throws Exception {

        BalitaRecordDTO balitaRecordDTO1 = balitaRecordService.update(balitaRecordDTO, id);
        return ResponseEntity.ok().body(balitaRecordDTO1);
    }

//    @PostMapping(value = "/visitPrescription")
//    public ResponseEntity<VisitPrescriptionDTO> addVisitPrescription(@RequestBody VisitPrescriptionDTO visitPrescriptionDTO) {
//
//        VisitPrescriptionDTO visitPrescriptionDTO1 = visitPrescriptionService.save(visitPrescriptionDTO);
//        return ResponseEntity.ok().body(visitPrescriptionDTO1);
//    }
//
//    @PutMapping(value = "/visitPrescription/{id}")
//    public ResponseEntity<VisitPrescriptionDTO> updateVisitPrescription(@RequestBody VisitPrescriptionDTO visitPrescriptionDTO, @PathVariable("id") long id)
//            throws Exception {
//
//        VisitPrescriptionDTO visitPrescriptionDTO1 = visitPrescriptionService.update(visitPrescriptionDTO, id);
//        return ResponseEntity.ok().body(visitPrescriptionDTO1);
//    }

    @DeleteMapping(value = "/balitaRecord/{id}")
    public Map<String, Boolean> deleteBalitaRecord(@PathVariable long id) throws Exception {
        return balitaRecordService.delete(id);
    }

//    @GetMapping(value = "/visitPrescription/{id}")
//    public ResponseEntity<VisitPrescriptionDTO> findById(@PathVariable long id) throws Exception {
//
//        VisitPrescriptionDTO visitPrescriptionDTO = visitPrescriptionService.getById(id);
//        return ResponseEntity.ok().body(visitPrescriptionDTO);
//    }

    @GetMapping(value = "/balitaRecord")
    public ResponseEntity<List<BalitaRecordDTO>> listAll() {
        List<BalitaRecordDTO> balitaRecordDTOList = balitaRecordService.getAll();
        return ResponseEntity.ok().body(balitaRecordDTOList);
    }


}
