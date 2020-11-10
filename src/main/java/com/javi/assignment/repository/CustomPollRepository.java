package com.javi.assignment.repository;

import com.javi.assignment.model.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomPollRepository extends MongoRepository<Poll, String> {

    List<Poll> findByInitiatedBetween(long creationDate, long creationDate2);

    List<Poll> findByInitiatedGreaterThan(long creationDate);

    List<Poll> findByInitiatedLessThan(long creationDate);

    List<Poll> findAllByTitleContains(String name);
}
