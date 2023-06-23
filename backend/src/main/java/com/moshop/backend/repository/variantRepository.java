package com.moshop.backend.repository;

import com.moshop.backend.model.Variant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface variantRepository extends MongoRepository<Variant,String> {

}
