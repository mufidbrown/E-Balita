package com.magang.plnicon.controller;

import com.magang.plnicon.dto.VisitPrescriptionDTO;
import com.magang.plnicon.service.VisitPrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class VisitPrescriptionController {

    @Autowired
    private VisitPrescriptionServiceImpl visitPrescriptionService;

    //ini tambahan dari VisitPrescriptio, logika ne digawe ngene wae. dan VisitPrescription sing mempunyai hak akses penuh adalah BIDAN
    @PostMapping(value = "/visitPrescription")
    @PreAuthorize("hasAuthority('ROLE_BIDAN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VisitPrescriptionDTO> addVisitPrescription(@RequestBody VisitPrescriptionDTO visitPrescriptionDTO) {

        VisitPrescriptionDTO visitPrescriptionDTO1 = visitPrescriptionService.save(visitPrescriptionDTO);
        return ResponseEntity.ok().body(visitPrescriptionDTO1);
    }


    @GetMapping(value = "/visitPrescription/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_BIDAN','ROLE_ORANG_TUA')")
    public ResponseEntity<VisitPrescriptionDTO> findById(@PathVariable long id) throws Exception {

        VisitPrescriptionDTO visitPrescriptionDTO = visitPrescriptionService.getById(id);
        return ResponseEntity.ok().body(visitPrescriptionDTO);
    }

    @PutMapping(value = "/visitPrescription/{id}")
    @PreAuthorize("hasAuthority('ROLE_BIDAN')")
    public ResponseEntity<VisitPrescriptionDTO> updateVisitPrescription(@RequestBody VisitPrescriptionDTO visitPrescriptionDTO, @PathVariable("id") long id)
            throws Exception {

        VisitPrescriptionDTO visitPrescriptionDTO1 = visitPrescriptionService.update(visitPrescriptionDTO, id);
        return ResponseEntity.ok().body(visitPrescriptionDTO1);
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

    @DeleteMapping(value = "/visitPrescription/{id}")
    public Map<String, Boolean> deleteVisitPrescription(@PathVariable long id) throws Exception {
        return visitPrescriptionService.delete(id);
    }

//    @GetMapping(value = "/visitPrescription/{id}")
//    public ResponseEntity<VisitPrescriptionDTO> findById(@PathVariable long id) throws Exception {
//
//        VisitPrescriptionDTO visitPrescriptionDTO = visitPrescriptionService.getById(id);
//        return ResponseEntity.ok().body(visitPrescriptionDTO);
//    }

    @GetMapping(value = "/visitPrescription")
    public ResponseEntity<List<VisitPrescriptionDTO>> listAll() {
        List<VisitPrescriptionDTO> visitPrescriptionDTOList = visitPrescriptionService.getAll();
        return ResponseEntity.ok().body(visitPrescriptionDTOList);
    }


}
