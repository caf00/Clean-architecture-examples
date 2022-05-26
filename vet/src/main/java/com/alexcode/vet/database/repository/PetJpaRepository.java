package com.alexcode.vet.database.repository;

import com.alexcode.vet.database.model.PetDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetJpaRepository extends JpaRepository<PetDb, Integer> {
}
