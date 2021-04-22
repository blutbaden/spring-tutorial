package com.reactive.springwebflux.web;

import com.reactive.springwebflux.repositories.CurrencyRepository;
import com.reactive.springwebflux.repositories.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    private CurrencyRepository currencyRepository;
    private TransactionRepository transactionRepository;

    public WebController(CurrencyRepository currencyRepository, TransactionRepository transactionRepository) {
        this.currencyRepository = currencyRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currencies", currencyRepository.findAll());
        return "index";
    }


}
