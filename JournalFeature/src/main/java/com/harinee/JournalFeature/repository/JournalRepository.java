package com.harinee.JournalFeature.repository;


import com.harinee.JournalFeature.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<Journal, String> {
}
