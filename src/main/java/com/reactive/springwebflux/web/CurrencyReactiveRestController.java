package com.reactive.springwebflux.web;

import com.reactive.springwebflux.entities.Currency;
import com.reactive.springwebflux.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CurrencyReactiveRestController {
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping(value = "/currencies")
    public Flux<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @GetMapping(value = "/currencies/{id}")
    public Mono<Currency> findById(@PathVariable String id) {
        return currencyRepository.findById(id);
    }

    @PostMapping(value = "/currencies")
    public Mono<Currency> save(@RequestBody Currency currency) {
        return currencyRepository.save(currency);
    }

    @PutMapping(value = "/currencies")
    public Mono<Currency> update(@RequestBody Currency currency) {
        return currencyRepository.save(currency);
    }

    @DeleteMapping(value = "/currencies/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return currencyRepository.deleteById(id);
    }
}
