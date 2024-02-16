package com.microservices.mongodbservice;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface NumbersDataRepository extends MongoRepository<NumbersData, String> {
}