package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private String name;
	  private int balance;
	  
	  public Account() {}
	  
	  public Account(String name, int balance) {
		    this.name = name;
		    this.balance = balance;
		  }
	  @Override
	  public String toString() {
		    return "Account [id= " + id + ", name=" + name + ", balance= " + balance + "]";
		  }

		  public Long getId() {
		    return id;
		  }
		  public void setId(Long id) {
			  this.id = id;
		  }
		  
		  public String getName() {
			  return name;
		  }
		  public void setName(String name) {
			  this.name = name;
		  }
		  
		  public int getbalance() {
			  return balance;
		  }
		  public void setBalance(int balance) {
			  this.balance = balance;
		  }
	}
