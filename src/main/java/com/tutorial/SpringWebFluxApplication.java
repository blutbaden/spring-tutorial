package com.tutorial;

import com.tutorial.entities.Currency;
import com.tutorial.repositories.CurrencyRepository;
import com.tutorial.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CurrencyRepository currencyRepository, TransactionRepository transactionRepository) {
        return args -> {
            currencyRepository.deleteAll().subscribe(null, null, () -> {
                Stream.of("EUR/USD", "GBP/USD").forEach(s -> {
                    currencyRepository.save(new Currency(s, 1.2 + Math.random() / 10))
                            .subscribe();
                });
            });
        };
    }

}
