package com.example.punto8.repository;

import com.example.punto8.model.Account;
import com.example.punto8.model.Bank;
import com.example.punto8.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    public List<Account> findByUser(User user);

    public List<Account> findByUserAndBank(User user, Bank bank);

    public Optional<Account> findByAccountId(String accountId);
}
