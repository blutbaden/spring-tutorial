package com.tutorial.repositories;

import com.tutorial.entities.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
