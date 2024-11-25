package com.harinee.JournalFeature.service;

import com.harinee.JournalFeature.model.Journal;
import com.harinee.JournalFeature.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(String id) {
        return journalRepository.findById(id);
    }

    public Journal createJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public void deleteJournal(String id) {
        journalRepository.deleteById(id);
    }
}

