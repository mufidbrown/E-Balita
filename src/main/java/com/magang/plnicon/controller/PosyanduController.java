package com.magang.plnicon.controller;

import com.magang.plnicon.entity.Posyandu;
import com.magang.plnicon.service.PosyanduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posyandu")
public class PosyanduController {

    private final PosyanduService posyanduService;

    @Autowired
    public PosyanduController(PosyanduService posyanduService) {
        this.posyanduService = posyanduService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Posyandu>> getAllPosyandu() {
        List<Posyandu> posyandus = posyanduService.getAllPosyandu();
        return new ResponseEntity<>(posyandus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Posyandu> getPosyanduById(@PathVariable Integer id) {
        Posyandu posyandu = posyanduService.getPosyanduById(id);
        if (posyandu != null) {
            return new ResponseEntity<>(posyandu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Posyandu> createPosyandu(@RequestBody Posyandu posyandu) {
        Posyandu createdPosyandu = posyanduService.createPosyandu(posyandu);
        return new ResponseEntity<>(createdPosyandu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Posyandu> updatePosyandu(@PathVariable Integer id, @RequestBody Posyandu posyandu) {
        Posyandu updatedPosyandu = posyanduService.updatePosyandu(id, posyandu);
        if (updatedPosyandu != null) {
            return new ResponseEntity<>(updatedPosyandu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deletePosyandu(@PathVariable Integer id) {
        posyanduService.deletePosyandu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


//import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//
//@RestController
//@RequestMapping("/posyandu")
//public class PosyanduController {
//
//    private final PosyanduService posyanduService;
//
//    @Autowired
//    public PosyanduController(PosyanduService posyanduService) {
//        this.posyanduService = posyanduService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Posyandu>> getAllPosyandu() {
//        List<Posyandu> posyandus = posyanduService.getAllPosyandu();
//        if (!posyandus.isEmpty()) {
//            return new ResponseEntity<>(posyandus, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Posyandu> getPosyanduById(@PathVariable Integer id) {
//        Posyandu posyandu = posyanduService.getPosyanduById(id);
//        if (posyandu != null) {
//            return new ResponseEntity<>(posyandu, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Posyandu> createPosyandu(@RequestBody Posyandu posyandu) {
//        if (posyandu != null) {
//            Posyandu createdPosyandu = posyanduService.createPosyandu(posyandu);
//            return new ResponseEntity<>(createdPosyandu, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Posyandu> updatePosyandu(@PathVariable Integer id, @RequestBody Posyandu posyandu) {
//        if (posyandu != null) {
//            Posyandu updatedPosyandu = posyanduService.updatePosyandu(id, posyandu);
//            if (updatedPosyandu != null) {
//                return new ResponseEntity<>(updatedPosyandu, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePosyandu(@PathVariable Integer id) {
//        Posyandu posyandu = posyanduService.getPosyanduById(id);
//        if (posyandu != null) {
//            posyanduService.deletePosyandu(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}
