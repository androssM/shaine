package com.shane.repository;

import com.shane.entity.Deliver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends MongoRepository<Deliver,String> {
}
