package com.microservices.mysqlservice;



import org.springframework.data.repository.CrudRepository;


public interface NumbersRepository extends CrudRepository<Numbers, Integer> {

}