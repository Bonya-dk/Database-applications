package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

  List<Account> findByNameStartingWith(String name);

  List<Account> findById(long id);
  
  List<Account> findByBalanceBetween(int i, int j);
}