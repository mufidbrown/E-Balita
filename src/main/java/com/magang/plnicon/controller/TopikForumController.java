package com.magang.plnicon.controller;


import com.magang.plnicon.entity.TopikForum;
import com.magang.plnicon.service.TopikForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topikforum")
public class TopikForumController {

    private final TopikForumService topikForumService;

    @Autowired
    public TopikForumController(TopikForumService topikForumService) {
        this.topikForumService = topikForumService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getAllTopikForum() {
        List<TopikForum> allTopikForum = topikForumService.getAllTopikForum();
        if (!allTopikForum.isEmpty()) {
            return ResponseEntity.ok(allTopikForum);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tidak ada TopikForum yang ditemukan");
        }
    }



    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getTopikForumById(@PathVariable Integer id) {
        TopikForum topikForum = topikForumService.getTopikForumById(id);
        if (topikForum != null) {
            return ResponseEntity.ok(topikForum);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TopikForum dengan ID " + id + " tidak ditemukan");
        }
    }


    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> createPengguna(@RequestBody TopikForum topikForum) {
        if (topikForum != null) {
            try {
                TopikForum createdTopikForum = topikForumService.createTopikForum(topikForum);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdTopikForum);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal membuat TopikForum: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid TopikForum input");
        }
    }



    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<TopikForum> updateTopikForum(@PathVariable Integer id, @RequestBody TopikForum newTopikForum) {
        try {
            TopikForum updatedTopikForum = topikForumService.updateTopikForum(id, newTopikForum);
            if (updatedTopikForum!= null) {
                return ResponseEntity.ok(updatedTopikForum);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TopikForum dengan ID " + id + " tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteTopikForum(@PathVariable Integer id) {
        TopikForum topikForum = topikForumService.getTopikForumById(id);
        if (topikForum != null) {
            topikForumService.deleteTopikForum(id);
            return ResponseEntity.ok("TopikForum dengan ID " + id + " berhasil dihapus");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

