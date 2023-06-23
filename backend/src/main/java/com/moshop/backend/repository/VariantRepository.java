package com.moshop.backend.repository;

import com.moshop.backend.model.Variant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends MongoRepository<Variant,String> {

}
