package com.alexcode.vet.core.domain;

import com.alexcode.vet.core.Pagination;
import com.alexcode.vet.core.domain.entity.Human;

import java.util.Optional;

public interface HumanRepository {
    Pagination<Human> findAll(Integer page, Integer size);
    Optional<Human> findById(Integer id);
    void save(Human human);
    void update(Human human);
}
