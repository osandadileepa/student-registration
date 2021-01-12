package com.osanda.classservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.osanda.classservice.entity.SchoolClass;

@Repository
public interface ClassRepository extends MongoRepository<SchoolClass, String> {
}
