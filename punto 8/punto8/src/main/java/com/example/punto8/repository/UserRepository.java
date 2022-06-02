package com.example.punto8.repository;

import com.example.punto8.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByNameAndPassword(String name, String password);
}
