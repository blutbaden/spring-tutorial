package com.tutorial.repositories;

import com.tutorial.entities.Currency;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CurrencyRepository extends ReactiveMongoRepository<Currency, String> {
}
