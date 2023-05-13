package com.example.demo.controller;

import com.example.demo.model.Journal;
import com.example.demo.repository.JournalRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalController {
    @Autowired
    private JournalRepository journalRepository;

    @GetMapping("")
    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    @PostMapping("")
    public Journal create(@RequestBody Journal journal) {
        return journalRepository.save(journal);
    }

    @GetMapping("/{id}")
    public Journal getById(@PathVariable Long id) {
        return journalRepository.findById(id).orElseThrow(() -> new ErrorResponseException("Journal not found"));
    }

    @PutMapping("/{id}")
    public Journal update(@PathVariable Long id, @RequestBody Journal journal) {
        Journal existingJournal = journalRepository.findById(id).orElseThrow(() -> new NotFoundException("Journal not found"));
        existingJournal.setTitle(journal.getTitle());
        existingJournal.setContent(journal.getContent());
        return journalRepository.save(existingJournal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Journal journal = journalRepository.findById(id).orElseThrow(() -> new NotFoundException("Journal not found"));
        journalRepository.delete(journal);
    }
}
