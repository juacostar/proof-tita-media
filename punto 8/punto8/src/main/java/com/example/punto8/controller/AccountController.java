package com.example.punto8.controller;

import com.example.punto8.RequestModel.RequestPay;
import com.example.punto8.model.Account;
import com.example.punto8.model.Bank;
import com.example.punto8.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("banks/{id}")
    public ResponseEntity<Set<Bank>> findBanksByUser(@PathVariable Integer id){
        return ResponseEntity.ok().body(accountService.findBanksByUser(id));
    }

    @GetMapping("accounts/{id}/{bank}")
    public ResponseEntity<List<Account>> findAccountsByUser(@PathVariable Integer id, @PathVariable Integer bank){
        return ResponseEntity.ok().body(accountService.findByUserAndBank(id, bank));
    }

    @PutMapping("accounts/pay/{id}")
    public ResponseEntity<Void> payAccount(@PathVariable String id, @RequestBody RequestPay requestPay){
        accountService.pay(id, requestPay.getAmount(), requestPay.getDues());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
