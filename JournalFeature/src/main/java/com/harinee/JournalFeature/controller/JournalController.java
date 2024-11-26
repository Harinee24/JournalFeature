package com.harinee.JournalFeature.controller;


import com.harinee.JournalFeature.model.Journal;
import com.harinee.JournalFeature.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journals")
@CrossOrigin(origins = "http://localhost:3000")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    public ResponseEntity<List<Journal>> getAllJournals() {
        return ResponseEntity.ok(journalService.getAllJournals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable String id) {
        Optional<Journal> journal = journalService.getJournalById(id);
        return journal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Journal> createJournal(@RequestBody Journal journal) {
        if (journal.getCreatedAt() == null) {
            journal.setCreatedAt(LocalDateTime.now());
        }
        return ResponseEntity.ok(journalService.createJournal(journal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournal(@PathVariable String id) {
        journalService.deleteJournal(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journal> updateJournal(@PathVariable String id, @RequestBody Journal updatedJournal) {
        Optional<Journal> existingJournal = journalService.getJournalById(id);
        if (existingJournal.isPresent()) {
            updatedJournal.setId(id);
            return ResponseEntity.ok(journalService.updateJournal(updatedJournal));
        }
        return ResponseEntity.notFound().build();
    }

}

