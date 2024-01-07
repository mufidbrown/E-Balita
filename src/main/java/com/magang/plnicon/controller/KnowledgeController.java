package com.magang.plnicon.controller;

import com.magang.plnicon.entity.Knowledge;
import com.magang.plnicon.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/knowledge")
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
    public ResponseEntity<Knowledge> getKnowledgeById(@PathVariable Integer id) {
        Knowledge knowledge = knowledgeService.getKnowledgeById(id);
        if (knowledge != null) {
            return ResponseEntity.ok(knowledge);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Knowledge> createKnowledge(@RequestBody Knowledge knowledge) {
        if (knowledge.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            Knowledge createdKnowledge = knowledgeService.createKnowledge(knowledge);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdKnowledge);
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Knowledge> updateKnowledge(@PathVariable Integer id, @RequestBody Knowledge newKnowledge) {
        Knowledge updatedKnowledge = knowledgeService.updateKnowledge(id, newKnowledge);
        if (updatedKnowledge != null) {
            return ResponseEntity.ok(updatedKnowledge);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteKnowledge(@PathVariable Integer id) {
        try {
            knowledgeService.deleteKnowledge(id);
            return ResponseEntity.ok("Knowledge dengan ID " + id + " berhasil dihapus");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Knowledge dengan ID " + id + " tidak ditemukan");
        }
    }
}
