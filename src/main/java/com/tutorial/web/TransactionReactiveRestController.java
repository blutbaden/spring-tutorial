package com.tutorial.web;

import com.tutorial.entities.Transaction;
import com.tutorial.repositories.CurrencyRepository;
import com.tutorial.repositories.TransactionRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@RestController
public class TransactionReactiveRestController {

    private TransactionRepository transactionRepository;
    private CurrencyRepository currencyRepository;

    public TransactionReactiveRestController(TransactionRepository transactionRepository, CurrencyRepository currencyRepository) {
        this.transactionRepository = transactionRepository;
        this.currencyRepository = currencyRepository;
    }

    @GetMapping(value = "/transactions")
    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @GetMapping(value = "/transactions/{id}")
    public Mono<Transaction> findById(@PathVariable String id) {
        return transactionRepository.findById(id);
    }

    @PostMapping(value = "/transactions")
    public Mono<Transaction> save(@RequestBody Transaction Transaction) {
        return transactionRepository.save(Transaction);
    }

    @PutMapping(value = "/transactions")
    public Mono<Transaction> update(@RequestBody Transaction Transaction) {
        return transactionRepository.save(Transaction);
    }

    @DeleteMapping(value = "/transactions/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return transactionRepository.deleteById(id);
    }

    @GetMapping(value = "/stream-transaction/currency/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Transaction> stream(@PathVariable String id) {
        return currencyRepository.findById(id).flatMapMany(currency -> {
            Flux<Long> interval = Flux.interval(Duration.ofMillis(1000));
            Flux<Transaction> transactionFlux = Flux.fromStream(Stream.generate(() -> {
                Transaction transaction = new Transaction();
                transaction.setInstant(Instant.now());
                transaction.setCurrency(currency);
                transaction.setPrice(currency.getPrice() * (1 + (Math.random() * 20) / 100));
                return transaction;
            }));
            return Flux.zip(interval, transactionFlux)
                    .map(Tuple2::getT2)
                    .share();
        });
    }
}
