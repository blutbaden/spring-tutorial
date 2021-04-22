package com.reactive.springwebflux.repositories;

import com.reactive.springwebflux.entities.Currency;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CurrencyRepository extends ReactiveMongoRepository<Currency, String> {
}
