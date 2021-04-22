package com.tutorial.repositories;

import com.tutorial.entities.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {

}
