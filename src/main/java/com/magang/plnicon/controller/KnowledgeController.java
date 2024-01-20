package com.magang.plnicon.controller;

import com.magang.plnicon.entity.Knowledge;
import com.magang.plnicon.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/knowledge/auth")
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    @Autowired
    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Knowledge>> getAllKnowledge() {
        List<Knowledge> allKnowledge = knowledgeService.getAllKnowledge();
        if (!allKnowledge.isEmpty()) {
            return ResponseEntity.ok(allKnowledge);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKnowledgeById(@PathVariable Integer id) {
        if (id != null) {
            try {
                Knowledge knowledge = knowledgeService.getKnowledgeById(id);
                return ResponseEntity.ok(knowledge);
            } catch (IllegalArgumentException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID input");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createKnowledge(@RequestBody Knowledge knowledge) {
        if (knowledge != null) {
            try {
                Knowledge createdKnowledge = knowledgeService.createKnowledge(knowledge);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdKnowledge);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat knowledge: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Knowledge input");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Knowledge> updateKnowledge(@PathVariable Integer id, @RequestBody Knowledge newKnowledge) {
        try {
            Knowledge updatedKnowledge = knowledgeService.updateKnowledge(id, newKnowledge);
            if (updatedKnowledge!= null) {
                return ResponseEntity.ok(updatedKnowledge);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Knowledge dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



//    ini bagus untuk jadi referensi logic pengkodingan saya
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteKnowledge(@PathVariable Integer id) {
        if (id != null) {
            Knowledge knowledge = knowledgeService.getKnowledgeById(id);
            if (knowledge != null) {
                knowledgeService.deleteKnowledge(id);
                return ResponseEntity.ok("Knowledge dengan ID " + id + " berhasil dihapus");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Knowledge dengan ID " + id + " tidak ditemukan");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID input");
        }
    }


}



//    @PostMapping("/create")
//    public ResponseEntity<Knowledge> createKnowledge(@RequestBody Knowledge knowledge) {
//        if (knowledge.getId() != null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        } else {
//            Knowledge createdKnowledge = knowledgeService.createKnowledge(knowledge);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdKnowledge);
//        }
//    }


//    @GetMapping("/{id}")
//    public ResponseEntity<Knowledge> getKnowledgeById(@PathVariable Integer id) {
//        Knowledge knowledge = knowledgeService.getKnowledgeById(id);
//        if (knowledge != null) {
//            return ResponseEntity.ok(knowledge);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }


//    @PutMapping("/{id}/update")
//    public ResponseEntity<Knowledge> updateKnowledge(@PathVariable Integer id, @RequestBody Knowledge newKnowledge) {
//        Knowledge updatedKnowledge = knowledgeService.updateKnowledge(id, newKnowledge);
//        if (updatedKnowledge != null) {
//            return ResponseEntity.ok(updatedKnowledge);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }


//    @DeleteMapping("/{id}/delete")
//    public ResponseEntity<String> deleteKnowledge(@PathVariable Integer id) {
//        try {
//            knowledgeService.deleteKnowledge(id);
//            return ResponseEntity.ok("Knowledge dengan ID " + id + " berhasil dihapus");
//        } catch (EntityNotFoundException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Knowledge dengan ID " + id + " tidak ditemukan");
//        }
//    }


