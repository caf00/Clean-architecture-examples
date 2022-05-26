package com.alexcode.vet.database.repository;

import com.alexcode.vet.database.model.HumanDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanJpaRepository extends JpaRepository<HumanDb, Integer> {
}
