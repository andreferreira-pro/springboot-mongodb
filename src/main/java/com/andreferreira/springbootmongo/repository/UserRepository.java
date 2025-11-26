package com.andreferreira.springbootmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andreferreira.springbootmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
