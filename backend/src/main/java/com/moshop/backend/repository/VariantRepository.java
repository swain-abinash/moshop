package com.moshop.backend.repository;

import com.moshop.backend.model.entity.Variant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantRepository extends MongoRepository<Variant, String> {
    List<Variant> findAllByIsActive(boolean isActive);
}
