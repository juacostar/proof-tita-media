package com.example.punto8.service;

import com.example.punto8.model.Account;
import com.example.punto8.model.Bank;
import com.example.punto8.model.User;
import com.example.punto8.repository.AccountRepository;
import com.example.punto8.repository.BankRepository;
import com.example.punto8.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final BankRepository bankRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, BankRepository bankRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
    }

    public Set<Bank> findBanksByUser(Integer userId){
        Optional<User> user = userRepository.findById(userId);
        List<Account> accounts = accountRepository.findByUser(user.get());
        Set<Bank> banks = new HashSet<>();
        for(Account account: accounts){
            banks.add(account.getBank());
        }
        return banks;
    }

    public List<Account> findByUserAndBank(Integer userId, Integer bankId){
        Optional<User> user = userRepository.findById(userId);
        Optional<Bank> bank = bankRepository.findById(bankId);
        return accountRepository.findByUserAndBank(user.get(), bank.get());
    }

    public void pay(String accountId, Double amount, Integer dues){
        Optional<Account> account = accountRepository.findByAccountId(accountId);
        if(dues == 0){
            if(amount == account.get().getAmount()) account.get().setAmount(0.0);
        }else{
            account.get().setDues(account.get().getDues() - dues);
            account.get().setAmount(account.get().getAmount() - amount);
            account.get().setPaidAmount(amount);
        }

        accountRepository.save(account.get());
    }

}
