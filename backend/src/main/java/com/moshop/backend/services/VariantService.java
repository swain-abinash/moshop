package com.moshop.backend.services;

import com.moshop.backend.model.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {
   void addVariant(Variant variant);
   List<Variant>getVariants();
   Optional<Variant> getVariant(String id);
   void deleteVariant(String Variant);
  void updateVariant(String id,Variant variant);
  long countAll();
  List<Variant>getActiveVariant();

}
