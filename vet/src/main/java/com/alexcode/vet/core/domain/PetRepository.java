package com.alexcode.vet.core.domain;

import com.alexcode.vet.core.Pagination;
import com.alexcode.vet.core.domain.entity.Pet;

import java.util.Optional;

public interface PetRepository {
    Pagination<Pet> findAll(Integer page, Integer size);
    Optional<Pet> findById(Integer id);
    void save(Pet pet);
    void update(Pet pet);
}
