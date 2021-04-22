package com.reactive.springwebflux.repositories;

import com.reactive.springwebflux.entities.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
